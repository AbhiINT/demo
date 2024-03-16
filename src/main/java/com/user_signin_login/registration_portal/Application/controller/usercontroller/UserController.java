package com.user_signin_login.registration_portal.Application.controller.usercontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/user-access")
    public String userAccess() {
        return " Only User Can access The End-Point";
    }

}
