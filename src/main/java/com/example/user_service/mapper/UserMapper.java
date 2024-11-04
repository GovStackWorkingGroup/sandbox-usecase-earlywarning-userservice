package com.example.user_service.mapper;

import com.example.user_service.models.CountryEnum;
import com.example.user_service.models.dtos.SimpleCountryDto;
import com.example.user_service.models.dtos.UserFullDto;
import com.example.user_service.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "countryId", target = "country", qualifiedByName = "mapCountryDto")
    UserFullDto entityToDto(User user);
    @Named("mapCountryDto")
    default SimpleCountryDto mapCountryDto(int countryId) {
        return SimpleCountryDto.builder()
                .countryId(CountryEnum.getById(countryId).getId())
                .name(CountryEnum.getById(countryId).getName())
                .build();
    }
}
