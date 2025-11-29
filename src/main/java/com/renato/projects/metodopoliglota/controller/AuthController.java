package com.renato.projects.metodopoliglota.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renato.projects.metodopoliglota.controller.dto.auth.LoginRequest;
import com.renato.projects.metodopoliglota.controller.dto.auth.TokenResponse;
import com.renato.projects.metodopoliglota.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        var authToken = new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        );

        Authentication authentication = authManager.authenticate(authToken);

        UserDetails user = (UserDetails) authentication.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new TokenResponse(token));
    }
}
