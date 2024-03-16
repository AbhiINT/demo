package com.user_signin_login.registration_portal.Application.service.userservice;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user_signin_login.registration_portal.Application.Model.admin.Admin;
import com.user_signin_login.registration_portal.Application.Model.user.User;
import com.user_signin_login.registration_portal.Application.dto.LoginRequest;
import com.user_signin_login.registration_portal.Application.dto.LoginResponse;
import com.user_signin_login.registration_portal.Application.dto.RegistrationRequest;
import com.user_signin_login.registration_portal.Application.dto.RegistrationResponse;
import com.user_signin_login.registration_portal.Application.dto.UserDTO;
import com.user_signin_login.registration_portal.Application.mapper.adminToAdminDTO.UserMapper;
import com.user_signin_login.registration_portal.Application.repository.userrepository.UserRepository;
import com.user_signin_login.registration_portal.util.jwtutils.JWTUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public LoginResponse signInUser(LoginRequest signinRequest) {

        LoginResponse response = new LoginResponse();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));

        User user = userRepository.findByEmail(signinRequest.getEmail());

        String jwt = jwtUtils.generateToken(user);

        response.setHttpStatusCode(HttpStatusCode.valueOf(200));
        response.setToken(jwt);
        response.setExpiratiionIn("3 MINUTES");
        response.setMessage("Successfully Signed In");

        return response;
    }

    @SuppressWarnings("unused")
    public RegistrationResponse handleSignUpUser(RegistrationRequest registrationRequest) {
        RegistrationResponse resp = new RegistrationResponse();

        User ourUsers = new User();
        ourUsers.setEmail(registrationRequest.getEmail());
        ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        ourUsers.setFirstName(registrationRequest.getFirstName());
        ourUsers.setLastName(registrationRequest.getLastName());
        ourUsers.setPhoneNumber(registrationRequest.getPhoneNumber());

        userRepository.save(ourUsers);

        if (ourUsers != null) {
            resp.setEmail(registrationRequest.getEmail());
            resp.setHttp(HttpStatusCode.valueOf(200));
            resp.setMessage("Registration Successfull");

        } else {
            resp.setEmail(registrationRequest.getEmail());
            resp.setHttp(HttpStatusCode.valueOf(400));
            resp.setMessage("Registration UnSuccessfull");
        }
        return resp;
    }

    public List<UserDTO> getAllUsers() {

        List<User> user = userRepository.findAll();
        List<UserDTO> res = userMapper.convertAdminListToUserDTOList(user);

        return res;

    }

}
