package com.example.user_service.controller;

import com.example.user_service.models.dtos.CommunicationChannelDto;
import com.example.user_service.models.dtos.CountryDto;
import com.example.user_service.models.dtos.LanguageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UtilityController {

    @GetMapping(path = "/getAllCountries")
    List<CountryDto> getAllCountries();

    @GetMapping(path = "/getCountryByName")
    CountryDto getCountryByName(@RequestParam String countryName);

    @GetMapping(path = "/getCountryById")
    CountryDto getCountryById(@RequestParam int countryId);

    @GetMapping(path = "/getAllLanguages")
    List<LanguageDto> getAllLanguages();

    @GetMapping(path = "/getAllCommunicationChannels")
    List<CommunicationChannelDto> getAllCommunicationChannels();
}
