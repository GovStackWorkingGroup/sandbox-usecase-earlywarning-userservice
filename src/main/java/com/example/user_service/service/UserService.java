package com.example.user_service.service;

import com.example.user_service.models.PermissionEnum;
import com.example.user_service.models.dtos.UserFullDto;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.models.CountryEnum;
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

    public List<UserFullDto> getAllUsers() {
        return this.userRepository.findAll().stream().map(e ->
                        UserFullDto.builder()
                                .userUUID(e.getUserUUID())
                                .firstName(e.getFirstName())
                                .lastName(e.getLastName())
                                .email(e.getEmail())
                                .contactPhone(e.getContactPhone())
                                .country(CountryEnum.getById(e.getCountryId()))
                                .build())
                .collect(Collectors.toList());
    }

    public boolean checkIfUserCanBroadcast(UUID userUuid, int countryId) {
        return this.userRepository.checkIfUserCanBroadcast(userUuid, PermissionEnum.BROADCAST.getName(), countryId).isPresent();
    }
}
