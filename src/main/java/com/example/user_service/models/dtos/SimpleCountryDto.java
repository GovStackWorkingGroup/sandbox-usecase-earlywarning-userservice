package com.example.user_service.models.dtos;

import lombok.Builder;

@Builder
public record SimpleCountryDto(int countryId, String name) {
}
