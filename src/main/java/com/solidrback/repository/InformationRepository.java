package com.solidrback.solidrback.repository;

import com.solidrback.solidrback.model.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationRepository extends JpaRepository<Information, Integer> {
    List<Information> findAllByInformationTypeEquals(String type);

    List<Information> findAllByInformationTypeEqualsAndInformationCodeIsNot(String type, String code);

}
