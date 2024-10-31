package com.example.user_service.models.dtos;

import lombok.Builder;

@Builder
public record EndUserRequestDto(int countryId, int countyId) {
}
