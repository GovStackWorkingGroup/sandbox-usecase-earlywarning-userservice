package com.example.user_service.controller;

import com.example.user_service.models.dtos.UserFullDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;


public interface UserController {

    @GetMapping(path = "/getAllUsers")
    ResponseEntity<List<UserFullDto>> getAllUsers();

    @GetMapping(path = "/canBroadcast")
    ResponseEntity canBroadcast(@RequestParam UUID userUuid, @RequestParam int countryId);

    @PostMapping(path = "/login")
    ResponseEntity<UserFullDto> login (@RequestParam String email, @RequestParam String password);
}
