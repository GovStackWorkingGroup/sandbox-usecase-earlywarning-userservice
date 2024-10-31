package com.example.user_service.service;

import com.example.user_service.models.PermissionEnum;
import com.example.user_service.models.dtos.CountryDto;
import com.example.user_service.models.dtos.EndUserDto;
import com.example.user_service.models.dtos.SimpleCountryDto;
import com.example.user_service.models.dtos.UserFullDto;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.models.CountryEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<UserFullDto>> getAllUsers() {
        return ResponseEntity.ok(this.userRepository.findAll().stream().map(e ->
                        UserFullDto.builder()
                                .userUUID(e.getUserUUID())
                                .firstName(e.getFirstName())
                                .lastName(e.getLastName())
                                .email(e.getEmail())
                                .contactPhone(e.getContactPhone())
                                .country(SimpleCountryDto.builder().countryId(e.getCountryId()).name(CountryEnum.getById(e.getCountryId()).getName()).build())
                                .build())
                .collect(Collectors.toList()));
    }

    public ResponseEntity checkIfUserCanBroadcast(UUID userUuid, int countryId) {
        return this.userRepository.checkIfUserCanBroadcast(userUuid, PermissionEnum.BROADCAST.getName(), countryId).isPresent() ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    public ResponseEntity<UserFullDto> simpleLogin(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password).map(user ->
                ResponseEntity.ok(UserFullDto.builder()
                        .userUUID(user.getUserUUID())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .contactPhone(user.getContactPhone())
                        .country(SimpleCountryDto.builder().countryId(user.getCountryId()).name(CountryEnum.getById(user.getCountryId()).getName()).build())
                        .build())
        ).orElse(ResponseEntity.status(HttpStatus.FORBIDDEN).build());
    }
}
