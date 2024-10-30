package com.example.user_service.models.dtos;

import com.example.user_service.models.LanguageEnum;
import lombok.Builder;

import java.util.List;

@Builder
public record CountryDto (int id, String name, List<LanguageEnum> countryLanguages) {
}
