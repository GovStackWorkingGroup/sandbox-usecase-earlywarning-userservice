package com.example.user_service.models.dtos;

import lombok.Builder;

@Builder
public record LanguageDto(int id, String name) {
}
