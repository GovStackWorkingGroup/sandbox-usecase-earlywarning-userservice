package global.govstack.user_service.models.dtos;

import lombok.Builder;

@Builder
public record EndUserRequestDto(int countryId, int countyId) {
}
