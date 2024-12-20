package global.govstack.user_service.service;

import global.govstack.user_service.models.CountyEnum;
import global.govstack.user_service.models.dtos.*;
import global.govstack.user_service.repository.EndUserRepository;
import global.govstack.user_service.models.CommunicationChannelEnum;
import global.govstack.user_service.models.CountryEnum;
import global.govstack.user_service.models.LanguageEnum;
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
                                .country(SimpleCountryDto.builder().countryId(CountryEnum.getById(e.getCountryId()).getId()).name(CountryEnum.getById(e.getCountryId()).getName()).build())
                                .county(CountyEnum.getById(e.getCountyId()))
                                .language(LanguageEnum.getById(e.getDefaultLanguageId()))
                                .defaultCommunicationChannel(CommunicationChannelEnum.getById(e.getDefaultCommunicationChannelId()))
                                .build())
                .collect(Collectors.toList());
    }

    public List<EndUserDto> getAllEndUsersForCounty(EndUserRequestDto requestDto) {
        return this.endUserRepository.findEndUserByCountryIdAndCountyId(requestDto.countryId(), requestDto.countyId())
                .stream().map(e ->
                        EndUserDto.builder()
                                .endUserUUID(e.getEndUserUUID())
                                .fullName(e.getFullName())
                                .email(e.getEmail())
                                .phoneNumber(e.getContactPhone())
                                .country(SimpleCountryDto.builder().countryId(CountryEnum.getById(e.getCountryId()).getId()).name(CountryEnum.getById(e.getCountryId()).getName()).build())
                                .county(CountyEnum.MOMBASA)
                                .language(LanguageEnum.getById(e.getDefaultLanguageId()))
                                .defaultCommunicationChannel(CommunicationChannelEnum.getById(e.getDefaultCommunicationChannelId()))
                                .build())
                .collect(Collectors.toList());

    }
}
