package com.onechallenge.forumhubby.controller;

import com.onechallenge.forumhubby.dto.DataAuth;
import com.onechallenge.forumhubby.infra.security.DataJWTToken;
import com.onechallenge.forumhubby.infra.security.TokenService;
import com.onechallenge.forumhubby.model.Member;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authMember(@RequestBody @Valid DataAuth dataAuth){
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataAuth.email(), dataAuth.password());
        var memberAuthenticated = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((Member) memberAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTtoken));
    }
}
