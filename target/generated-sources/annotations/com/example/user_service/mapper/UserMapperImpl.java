package com.example.user_service.mapper;

import com.example.user_service.models.UserFullDto;
import com.example.user_service.repository.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-11T10:52:36+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserFullDto entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserFullDto.UserFullDtoBuilder userFullDto = UserFullDto.builder();

        userFullDto.id( user.getId() );
        userFullDto.userUUID( user.getUserUUID() );
        userFullDto.firstName( user.getFirstName() );
        userFullDto.lastName( user.getLastName() );
        userFullDto.email( user.getEmail() );
        userFullDto.contactPhone( user.getContactPhone() );

        return userFullDto.build();
    }
}
