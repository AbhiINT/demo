package com.user_signin_login.registration_portal.Application.repository.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.user_signin_login.registration_portal.Application.Model.user.User;

public interface UserRepository extends JpaRepository<User , Long> {

    User findByEmail(String username);
    
}
