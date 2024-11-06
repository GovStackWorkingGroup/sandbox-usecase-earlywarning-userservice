package global.govstack.user_service.controller;

import global.govstack.user_service.models.dtos.EndUserDto;
import global.govstack.user_service.models.dtos.EndUserRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EndUserController {

    @GetMapping(path = "/getEndUsersForCountry")
    List<EndUserDto> getEndUsersForCountry(@RequestParam int countryId);
    @PostMapping(path = "/getEndUsersForCounty")
    List<EndUserDto> getEndUsersForCounty(@RequestBody EndUserRequestDto requestDto);

}
