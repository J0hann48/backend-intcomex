package com.intcomex.backendintcomex.service;

import com.intcomex.backendintcomex.config.JwtService;
import com.intcomex.backendintcomex.controllers.auth.AuthenticationRequest;
import com.intcomex.backendintcomex.controllers.auth.AuthenticationResponse;
import com.intcomex.backendintcomex.controllers.auth.RegisterRequest;
import com.intcomex.backendintcomex.enums.Role;
import com.intcomex.backendintcomex.model.entities.User;
import com.intcomex.backendintcomex.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationService authenticationService;

    private RegisterRequest registerRequest;
    private AuthenticationRequest authenticationRequest;
    private User user;
    private AuthenticationResponse authenticationResponse;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        registerRequest = new RegisterRequest();
        registerRequest.setName("Test User");
        registerRequest.setEmail("test@example.com");
        registerRequest.setPassword("password");

        authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail("test@example.com");
        authenticationRequest.setPassword("password");

        user = User.builder()
                .name("Test User")
                .email("test@example.com")
                .password("encodedPassword")
                .role(Role.USER)
                .build();

        authenticationResponse = AuthenticationResponse.builder()
                .token("fake-jwt-token")
                .build();
    }

    @Test
    public void testRegister() {
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(jwtService.generateToken(any(User.class))).thenReturn("fake-jwt-token");

        AuthenticationResponse response = authenticationService.register(registerRequest);

        verify(repository).save(any(User.class));
        assert response.getToken().equals("fake-jwt-token");
    }

    @Test
    public void testAuthenticate() {
        when(repository.findByEmail(authenticationRequest.getEmail())).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any(User.class))).thenReturn("fake-jwt-token");

        AuthenticationResponse response = authenticationService.authenticate(authenticationRequest);

        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        assert response.getToken().equals("fake-jwt-token");
    }
}
