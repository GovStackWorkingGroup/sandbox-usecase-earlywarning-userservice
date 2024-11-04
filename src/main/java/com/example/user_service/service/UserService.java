package com.example.user_service.service;

import com.example.user_service.config.PasswordEncoder;
import com.example.user_service.models.PermissionEnum;
import com.example.user_service.models.dtos.SimpleCountryDto;
import com.example.user_service.models.dtos.UserFullDto;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.models.CountryEnum;
import com.example.user_service.repository.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        final Optional<User> userOptional = this.userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            final User user = userOptional.get();
            if (this.passwordEncoder.bCryptPasswordEncoder().matches(password, user.getPassword())) {
                return ResponseEntity.ok(UserFullDto.builder()
                        .userUUID(user.getUserUUID())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .contactPhone(user.getContactPhone())
                        .country(SimpleCountryDto.builder()
                                .countryId(user.getCountryId())
                                .name(CountryEnum.getById(user.getCountryId()).getName())
                                .build())
                        .build());
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
