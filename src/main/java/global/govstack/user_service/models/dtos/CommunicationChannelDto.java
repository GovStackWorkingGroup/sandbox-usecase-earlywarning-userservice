package global.govstack.user_service.models.dtos;

import lombok.Builder;

@Builder
public record CommunicationChannelDto(int id, String name) {
}
