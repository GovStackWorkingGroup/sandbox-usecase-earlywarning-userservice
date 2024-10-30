package com.example.user_service.repository;

import com.example.user_service.repository.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {

   List<EndUser>findEndUserByCountryId(int countryId);

}
