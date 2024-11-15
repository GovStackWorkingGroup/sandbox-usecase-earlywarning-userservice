package global.govstack.user_service.models.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record EndUserRequestDto(int countryId, List<Integer> countyId) {
}
