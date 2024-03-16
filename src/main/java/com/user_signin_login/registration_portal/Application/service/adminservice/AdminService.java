package com.user_signin_login.registration_portal.Application.service.adminservice;

import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user_signin_login.registration_portal.Application.Model.admin.Admin;
import com.user_signin_login.registration_portal.Application.dto.LoginRequest;
import com.user_signin_login.registration_portal.Application.dto.LoginResponse;
import com.user_signin_login.registration_portal.Application.dto.RegistrationRequest;
import com.user_signin_login.registration_portal.Application.dto.RegistrationResponse;
import com.user_signin_login.registration_portal.Application.repository.adminrepository.AdminRepository;
import com.user_signin_login.registration_portal.util.jwtutils.JWTUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AuthenticationManager authenticationManager;
    private final AdminRepository adminRepository;
    private final JWTUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginResponse signInAdmin(LoginRequest signinRequest) {

        LoginResponse response = new LoginResponse();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));

        Admin admin = adminRepository.findByEmail(signinRequest.getEmail());

        String jwt = jwtUtils.generateToken(admin);

        response.setHttpStatusCode(HttpStatusCode.valueOf(200));
        response.setToken(jwt);
        response.setExpiratiionIn("3 MINUTES");
        response.setMessage("Successfully Signed In");

        return response;
    }

    public RegistrationResponse handleSignUpAdmin(RegistrationRequest registrationRequest) {
        RegistrationResponse resp = new RegistrationResponse();

        Admin ourUsers = new Admin();
        ourUsers.setEmail(registrationRequest.getEmail());
        ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        ourUsers.setFirstName(registrationRequest.getFirstName());
        ourUsers.setLastName(registrationRequest.getLastName());
        ourUsers.setPhoneNumber(registrationRequest.getPhoneNumber());

        Admin admin = adminRepository.save(ourUsers);
        resp.setEmail(registrationRequest.getEmail());
        resp.setHttp(HttpStatusCode.valueOf(200));
        resp.setMessage("Registration Successfull");

        if (admin == null) {
            resp.setEmail(registrationRequest.getEmail());
            resp.setHttp(HttpStatusCode.valueOf(404));
            resp.setMessage("Registration UnSuccessfull");
        }

        return resp;
    }
}
