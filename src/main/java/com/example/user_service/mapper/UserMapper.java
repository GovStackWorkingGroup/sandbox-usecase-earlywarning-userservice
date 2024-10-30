package com.example.user_service.mapper;

import com.example.user_service.models.dtos.UserFullDto;
import com.example.user_service.repository.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserFullDto entityToDto(User user);
}
