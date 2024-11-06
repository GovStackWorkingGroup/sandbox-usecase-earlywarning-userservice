package global.govstack.user_service.controller;

import global.govstack.user_service.models.dtos.CommunicationChannelDto;
import global.govstack.user_service.models.dtos.CountryDto;
import global.govstack.user_service.models.dtos.LanguageDto;
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
