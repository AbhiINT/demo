package com.user_signin_login.registration_portal.Application.dto;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private HttpStatusCode httpStatusCode;
    private String message;
    private String token;
    private String expiratiionIn;
    
}
