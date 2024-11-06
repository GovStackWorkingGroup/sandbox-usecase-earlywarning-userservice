package global.govstack.user_service.service;

import global.govstack.user_service.models.CommunicationChannelEnum;
import global.govstack.user_service.models.CountryEnum;
import global.govstack.user_service.models.LanguageEnum;
import global.govstack.user_service.models.dtos.CommunicationChannelDto;
import global.govstack.user_service.models.dtos.CountryDto;
import global.govstack.user_service.models.dtos.LanguageDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilityService {
    public List<CountryDto> getAllCountries() {
        return Arrays.stream(CountryEnum.values()).map(c ->
                CountryDto.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .countryLanguages(c.getCountryLanguages())
                        .counties(c.getCounties())
                        .build()).collect(Collectors.toList());
    }

    public List<LanguageDto> getAllLanguages() {
        return Arrays.stream(LanguageEnum.values()).map(c -> LanguageDto.builder().id(c.getId()).name(c.getName()).build()).collect(Collectors.toList());
    }

    public List<CommunicationChannelDto> getAllCommunicationChannels() {
        return Arrays.stream(CommunicationChannelEnum.values()).map(c -> CommunicationChannelDto.builder().id(c.getId()).name(c.getName()).build()).collect(Collectors.toList());
    }

    public CountryDto getCountryByName(String countryName) {
        final CountryEnum countryEnum = CountryEnum.getByName(countryName);
        return CountryDto.builder()
                .id(countryEnum.getId())
                .name(countryEnum.getName())
                .countryLanguages(countryEnum.getCountryLanguages())
                .counties(countryEnum.getCounties())
                .build();
    }

    public CountryDto getCountryById(int countryId) {
        final CountryEnum countryEnum = CountryEnum.getById(countryId);
        return CountryDto.builder()
                .id(countryEnum.getId())
                .name(countryEnum.getName())
                .countryLanguages(countryEnum.getCountryLanguages())
                .counties(countryEnum.getCounties())
                .build();
    }
}
