package com.example.user_service.service;

import com.example.user_service.models.dtos.CommunicationChannelDto;
import com.example.user_service.models.dtos.CountryDto;
import com.example.user_service.models.dtos.EndUserDto;
import com.example.user_service.models.dtos.LanguageDto;
import com.example.user_service.repository.EndUserRepository;
import com.example.user_service.models.CommunicationChannelEnum;
import com.example.user_service.models.CountryEnum;
import com.example.user_service.models.LanguageEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EndUserService {

    private final EndUserRepository endUserRepository;

    public EndUserService(EndUserRepository endUserRepository) {
        this.endUserRepository = endUserRepository;
    }

    public List<EndUserDto> getAllEndUsersForCountry(int countryId) {
        return this.endUserRepository.findEndUserByCountryId(countryId).stream().map(e ->
                        EndUserDto.builder()
                                .endUserUUID(e.getEndUserUUID())
                                .fullName(e.getFullName())
                                .email(e.getEmail())
                                .phoneNumber(e.getContactPhone())
                                .country(CountryDto.builder().id(CountryEnum.getById(e.getCountryId()).getId()).name(CountryEnum.getById(e.getCountryId()).getName()).build())
                                .language(LanguageDto.builder().id(LanguageEnum.getById(e.getDefaultLanguageId()).getId()).name(LanguageEnum.getById(e.getDefaultLanguageId()).getName()).build())
                                .defaultCommunicationChannel(CommunicationChannelDto.builder().id(CommunicationChannelEnum.getById(e.getDefaultCommunicationChannelId()).getId()).name(CommunicationChannelEnum.getById(e.getDefaultCommunicationChannelId()).getName()).build())
                                .build())
                .collect(Collectors.toList());
    }
}
