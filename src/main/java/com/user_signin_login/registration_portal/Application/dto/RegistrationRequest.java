package com.user_signin_login.registration_portal.Application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {
   
    private String firstName;

  
    private String lastName;
 
    private String email;

    private String password;

    private String phoneNumber;

}
