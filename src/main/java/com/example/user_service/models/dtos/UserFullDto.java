package com.example.user_service.models.dtos;

import com.example.user_service.models.CountryEnum;
import lombok.Builder;

import java.util.UUID;
@Builder
public record UserFullDto(UUID userUUID, String firstName, String lastName, String email, String contactPhone, CountryEnum country) {

}
