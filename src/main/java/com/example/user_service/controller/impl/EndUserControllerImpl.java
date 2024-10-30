package com.example.user_service.controller.impl;

import com.example.user_service.controller.EndUserController;
import com.example.user_service.models.dtos.EndUserDto;
import com.example.user_service.service.EndUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/end-user/")
public class EndUserControllerImpl implements EndUserController {

    private final EndUserService endUserService;

    public EndUserControllerImpl(EndUserService endUserService) {
        this.endUserService = endUserService;
    }

    @Override
    public List<EndUserDto> getEndUsersForCountry(int countryId) {
        return this.endUserService.getAllEndUsersForCountry(countryId);
    }
}
