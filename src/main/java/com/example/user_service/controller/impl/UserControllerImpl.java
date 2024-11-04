package com.example.user_service.controller.impl;

import com.example.user_service.controller.UserController;
import com.example.user_service.controller.exception.NotFoundException;
import com.example.user_service.controller.exception.UnauthorizedException;
import com.example.user_service.models.dtos.UserFullDto;
import com.example.user_service.security.SecurityUtils;
import com.example.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/user/")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<UserFullDto>> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @Override
    public ResponseEntity canBroadcast(UUID userUuid, int countryId) {
        return this.userService.checkIfUserCanBroadcast(userUuid, countryId);
    }

    @Override
    public ResponseEntity<UserFullDto> currentUser() {
        String currentUserEmail = SecurityUtils.getCurrentUserLogin()
            .orElseThrow(() -> new UnauthorizedException("User not logged in"));

        UserFullDto user = userService.findUserByEmail(currentUserEmail)
            .orElseThrow(() -> new NotFoundException("User " + currentUserEmail + " not found"));

        return ResponseEntity.ok(user);
    }
}
