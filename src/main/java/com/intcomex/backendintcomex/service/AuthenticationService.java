package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.config.JwtAuthenticationFilter;
import com.intcomex.backendintcomex.config.JwtService;
import com.intcomex.backendintcomex.controllers.auth.AuthenticationRequest;
import com.intcomex.backendintcomex.controllers.auth.AuthenticationResponse;
import com.intcomex.backendintcomex.controllers.auth.RegisterRequest;
import com.intcomex.backendintcomex.enums.Role;
import com.intcomex.backendintcomex.model.entities.User;
import com.intcomex.backendintcomex.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        logger.info("User register {}", user.toString());
        repository.save(user);
        logger.info("User save in DB");

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        logger.info("User authenticate {}", user.getUsername());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
