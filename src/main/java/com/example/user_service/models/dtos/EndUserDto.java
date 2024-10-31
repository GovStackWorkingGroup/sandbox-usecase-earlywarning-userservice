package com.example.user_service.models.dtos;

import com.example.user_service.models.CommunicationChannelEnum;
import com.example.user_service.models.CountryEnum;
import com.example.user_service.models.CountyEnum;
import com.example.user_service.models.LanguageEnum;
import lombok.Builder;

import java.util.UUID;
@Builder
public record EndUserDto(UUID endUserUUID, String fullName, String email, String phoneNumber, SimpleCountryDto country, CountyEnum county, LanguageEnum language, CommunicationChannelEnum defaultCommunicationChannel) {
}
