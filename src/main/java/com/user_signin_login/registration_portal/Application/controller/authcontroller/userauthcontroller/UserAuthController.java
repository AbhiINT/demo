package com.user_signin_login.registration_portal.Application.controller.authcontroller.userauthcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_signin_login.registration_portal.Application.dto.LoginRequest;
import com.user_signin_login.registration_portal.Application.dto.LoginResponse;
import com.user_signin_login.registration_portal.Application.dto.RegistrationRequest;
import com.user_signin_login.registration_portal.Application.dto.RegistrationResponse;
import com.user_signin_login.registration_portal.Application.service.userservice.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/user")
@RequiredArgsConstructor
public class UserAuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<RegistrationResponse> signUp(@RequestBody RegistrationRequest registrationRequest) {

        return ResponseEntity.ok(userService.handleSignUpUser(registrationRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest signInRequest) {

        return ResponseEntity.ok(userService.signInUser(signInRequest));

    }

}
