package com.example.user_service.models.dtos;

import lombok.Builder;

import java.util.UUID;
@Builder
public record EndUserDto(UUID endUserUUID, String fullName, String email, String phoneNumber, CountryDto country, LanguageDto language, CommunicationChannelDto defaultCommunicationChannel) {
}
