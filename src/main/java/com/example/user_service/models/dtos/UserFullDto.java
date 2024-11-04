package com.example.user_service.models.dtos;

import java.util.UUID;

public record UserFullDto(UUID userUUID, String firstName, String lastName, String email, String contactPhone, SimpleCountryDto country) {

}
