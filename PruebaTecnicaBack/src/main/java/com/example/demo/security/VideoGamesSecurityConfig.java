package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class VideoGamesSecurityConfig {

    private static final String[] SECURED_URLs = {"/party/game", "/party/add", "/party/join", "/party/exit"};

    private static final String[] UN_SECURED_URLs = {
            "/user/add",
            "/login/**",
            "/swagger-ui/**"
    };

    @Autowired
    private JWTAuthenticationFilter authenticationFilter;

    @Autowired
    private VideoGamesUserDetailsService userDetailsService;



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
       return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
        		.authorizeHttpRequests(
        				auth -> auth
        				.requestMatchers(UN_SECURED_URLs).permitAll()
        				.requestMatchers(SECURED_URLs).hasAuthority("USER")
        				.anyRequest().authenticated())
        		.sessionManagement()
        		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        		.and()
        		.authenticationProvider(authenticationProvider())
        		.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
        		.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
