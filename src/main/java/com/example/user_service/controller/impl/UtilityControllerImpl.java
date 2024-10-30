package com.example.user_service.controller.impl;

import com.example.user_service.controller.UtilityController;
import com.example.user_service.models.dtos.CommunicationChannelDto;
import com.example.user_service.models.dtos.CountryDto;
import com.example.user_service.models.dtos.LanguageDto;
import com.example.user_service.service.UtilityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/utility/")
public class UtilityControllerImpl implements UtilityController {

    private final UtilityService utilityService;

    public UtilityControllerImpl(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return this.utilityService.getAllCountries();
    }

    @Override
    public List<LanguageDto> getAllLanguages() {
        return this.utilityService.getAllLanguages();
    }

    @Override
    public List<CommunicationChannelDto> getAllCommunicationChannels() {
        return this.utilityService.getAllCommunicationChannels();
    }
}
