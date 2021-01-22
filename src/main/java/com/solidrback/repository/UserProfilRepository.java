package com.solidrback.solidrback.repository;

import com.solidrback.solidrback.model.entity.UserProfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfilRepository extends JpaRepository<UserProfil, String> {
}