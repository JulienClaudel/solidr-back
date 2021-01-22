package com.solidrback.solidrback.service;

import com.solidrback.solidrback.model.entity.Information;

import java.util.List;

public interface InformationService {
    List<Information> findAll();

    List<Information> findAllByInformationTypeEqualsAndInformationCodeIsNot(String type, String code);
}
