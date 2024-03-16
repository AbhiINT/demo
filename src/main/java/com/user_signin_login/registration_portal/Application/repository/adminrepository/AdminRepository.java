package com.user_signin_login.registration_portal.Application.repository.adminrepository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.user_signin_login.registration_portal.Application.Model.admin.Admin;

public interface AdminRepository extends JpaRepository<Admin , Long> {

    Admin findByEmail(String username);
    
}
