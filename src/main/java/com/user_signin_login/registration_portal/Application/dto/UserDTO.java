package com.user_signin_login.registration_portal.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
