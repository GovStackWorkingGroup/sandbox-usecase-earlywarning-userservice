package com.example.user_service.repository;

import com.example.user_service.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = """
            SELECT ut.*
            FROM user_table ut
            WHERE ut.useruuid = :userUuid
            AND ut.countryId = :countryId
            AND EXISTS (
                SELECT 1
                FROM users_in_group uig
                JOIN user_group ug ON uig.groupuuid = ug.groupuuid
                JOIN user_group_permission ugp ON ug.groupuuid = ugp.groupuuid
                JOIN permission pt ON ugp.permissionuuid = pt.permissionuuid
                WHERE uig.useruuid = ut.useruuid AND pt.permissionname = :permissionName
            );
            """, nativeQuery = true)
    Optional<User> checkIfUserCanBroadcast(UUID userUuid, String permissionName, int countryId);

    Optional<User> findOneByEmailIgnoreCase(String login);
}
