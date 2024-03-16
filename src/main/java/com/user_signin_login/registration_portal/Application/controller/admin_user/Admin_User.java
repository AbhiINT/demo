package com.user_signin_login.registration_portal.Application.controller.admin_user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-user")
public class Admin_User {

    @GetMapping("/admin-user-access")
    public String user_admin_access() {
        return " Both User and Admin can access this Endpoint";
    }

}
