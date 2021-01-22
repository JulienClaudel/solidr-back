package com.solidrback.repository;

import com.solidrback.model.UserDataDTO;
import com.solidrback.model.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, String> {

    @Query("SELECT new com.solidrback.model.UserDataDTO(" +
            "ud.userEmail, " +
            "ud.statusId, " +
            "ud.userUsername," +
            "ud.userPassword," +
            "ud.userFirstname, " +
            "ud.userLastname, " +
            "ud.userBirthdate," +
            "ud.userSignin," +
            "ud.userDescription," +
            "ud.userLinkContact," +
            "ud.userGaz," +
            "ud.enabled) FROM UserData ud WHERE ud.userEmail = ?1")
    Optional<UserDataDTO> findUserDataByUserEmail(String userEmail);

    Optional<UserData> findByUserEmail(String userEmail);

    Optional<UserData> findByUserUsername(String username);

    Boolean existsByUserUsername(String username);

    Boolean existsByUserEmail(String email);

    UserData findByUserEmailIgnoreCase(String email);

    UserData findByConfirmationToken(String confirmationToken);
}
