package com.user_signin_login.registration_portal.config.filterchain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.user_signin_login.registration_portal.config.beanconfig.BeanConfig;
import com.user_signin_login.registration_portal.config.jwtfilter.JWTAuthFIlter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final BeanConfig beanConfig;
    private final JWTAuthFIlter jwtAuthFIlter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors(cors -> cors.configurationSource(beanConfig.corsConfigurationSource()));
        httpSecurity
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/auth/**", "/public/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/user/**").hasAnyAuthority("USER")
                        .requestMatchers("/admin-user/**").hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/auth/**", "/public/**", "/admin/**", "/user/**"))
                .authenticationProvider(beanConfig.authenticationProvider())
                .addFilterBefore(jwtAuthFIlter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
