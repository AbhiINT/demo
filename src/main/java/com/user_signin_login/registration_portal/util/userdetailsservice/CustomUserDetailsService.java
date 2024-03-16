package com.user_signin_login.registration_portal.util.userdetailsservice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.user_signin_login.registration_portal.Application.repository.adminrepository.AdminRepository;
import com.user_signin_login.registration_portal.Application.repository.userrepository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    
     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByEmail(username) == null ? adminRepository.findByEmail(username) : userRepository.findByEmail(username);

    }
}
