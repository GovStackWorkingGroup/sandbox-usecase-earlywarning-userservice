package global.govstack.user_service.repository;

import global.govstack.user_service.repository.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {

    List<EndUser> findEndUserByCountryId(int countryId);

    @Query("SELECT e FROM EndUser e WHERE e.countryId= :countryId and e.countyId in (:countyIds)")
    List<EndUser> findEndUserByCountryIdAndCountyId(int countryId, List<Integer> countyIds);

}
