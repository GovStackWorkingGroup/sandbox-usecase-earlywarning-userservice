package global.govstack.user_service.controller.impl;

import global.govstack.user_service.controller.UserController;
import global.govstack.user_service.controller.exception.NotFoundException;
import global.govstack.user_service.controller.exception.UnauthorizedException;
import global.govstack.user_service.models.dtos.UserFullDto;
import global.govstack.user_service.security.SecurityUtils;
import global.govstack.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/users/")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserFullDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserFullDto getUser(UUID userId) {
        return userService.getUser(userId)
                .orElseThrow(() -> new NotFoundException("User with ID " + userId + " not found"));
    }

    @Override
    public ResponseEntity<?> canBroadcast(UUID userUuid, int countryId) {
        return this.userService.checkIfUserCanBroadcast(userUuid, countryId) ? ResponseEntity.ok().body(Boolean.TRUE) : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "User is not authorized to broadcast",
                "userUuid", userUuid,
                "countryId", countryId));
    }

    @Override
    public UserFullDto currentUser() {
        String currentUserEmail = SecurityUtils.getCurrentUserLogin()
                .orElseThrow(() -> new UnauthorizedException("User not logged in"));

        return userService.findUserByEmail(currentUserEmail)
                .orElseThrow(() -> new NotFoundException("User " + currentUserEmail + " not found"));
    }
}
