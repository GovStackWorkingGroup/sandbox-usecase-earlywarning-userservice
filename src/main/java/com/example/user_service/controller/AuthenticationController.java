package com.example.user_service.controller;

import com.example.user_service.security.JWTToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthenticationController {

    @PostMapping(path = "/login")
    ResponseEntity<JWTToken> authenticate (@RequestParam String email, @RequestParam String password);

}
