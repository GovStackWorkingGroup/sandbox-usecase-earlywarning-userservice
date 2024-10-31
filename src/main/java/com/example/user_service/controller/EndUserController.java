package com.example.user_service.controller;

import com.example.user_service.models.dtos.EndUserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EndUserController {

    @GetMapping(path = "/getEndUsersForCountry")
    List<EndUserDto> getEndUsersForCountry(@RequestParam int countryId);
    @GetMapping(path = "/getEndUsersForCounty")
    List<EndUserDto> getEndUsersForCounty(@RequestParam int countryId, @RequestParam int countyId);

}
