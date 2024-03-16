package com.user_signin_login.registration_portal.Application.controller.admincontroller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_signin_login.registration_portal.Application.dto.UserDTO;
import com.user_signin_login.registration_portal.Application.service.adminservice.AdminService;
import com.user_signin_login.registration_portal.Application.service.userservice.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserDTO>> getAllUser() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/admin-access")
    public String userAccess() {
        return " Only Admin Can access The End-Point";
    }

}
