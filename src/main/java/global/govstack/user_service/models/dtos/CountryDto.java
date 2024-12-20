package global.govstack.user_service.models.dtos;

import global.govstack.user_service.models.CountyEnum;
import global.govstack.user_service.models.LanguageEnum;
import lombok.Builder;

import java.util.List;

@Builder
public record CountryDto (int id, String name, List<LanguageEnum> countryLanguages, List<CountyEnum> counties) {
}
