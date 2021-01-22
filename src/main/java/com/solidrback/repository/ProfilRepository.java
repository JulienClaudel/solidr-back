package com.solidrback.solidrback.repository;
import com.solidrback.solidrback.model.entity.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {

	Optional<Profil> findByProfilLabel(String profilLabel);
}
