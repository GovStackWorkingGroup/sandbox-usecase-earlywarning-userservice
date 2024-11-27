package global.govstack.user_service.controller;

import global.govstack.user_service.models.dtos.UserFullDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface UserController {

    @GetMapping("/{userId}")
    UserFullDto getUser(@PathVariable UUID userId);

    @GetMapping(path = "/canBroadcast")
    ResponseEntity<?> canBroadcast(@RequestParam UUID userUuid, @RequestParam int countryId);

    @GetMapping(path = "/checkUser")
    ResponseEntity<?> checkUser(@RequestParam UUID userId);

    @GetMapping(path = "/me")
    UserFullDto currentUser();

}
