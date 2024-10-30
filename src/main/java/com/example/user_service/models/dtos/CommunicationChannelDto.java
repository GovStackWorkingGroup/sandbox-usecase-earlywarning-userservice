package com.example.user_service.models.dtos;

import lombok.Builder;

@Builder
public record CommunicationChannelDto(int id, String name) {
}
