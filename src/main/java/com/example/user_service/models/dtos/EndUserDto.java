package global.govstack.user_service.models.dtos;

import global.govstack.user_service.models.CommunicationChannelEnum;
import global.govstack.user_service.models.CountryEnum;
import global.govstack.user_service.models.CountyEnum;
import global.govstack.user_service.models.LanguageEnum;
import lombok.Builder;

import java.util.UUID;
@Builder
public record EndUserDto(UUID endUserUUID, String fullName, String email, String phoneNumber, SimpleCountryDto country, CountyEnum county, LanguageEnum language, CommunicationChannelEnum defaultCommunicationChannel) {
}
