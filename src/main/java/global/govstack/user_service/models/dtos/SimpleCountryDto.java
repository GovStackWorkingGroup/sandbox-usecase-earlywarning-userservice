package global.govstack.user_service.models.dtos;

import lombok.Builder;

@Builder
public record SimpleCountryDto(int countryId, String name) {
}
