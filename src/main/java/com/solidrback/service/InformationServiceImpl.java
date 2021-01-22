package com.solidrback.service;

import com.solidrback.model.entity.Information;
import com.solidrback.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    InformationRepository informationRepository;

    @Override
    public List<Information> findAll() {
        return informationRepository.findAll();
    }

    @Override
    public List<Information> findAllByInformationTypeEqualsAndInformationCodeIsNot(String type, String code) {
        return informationRepository.findAllByInformationTypeEqualsAndInformationCodeIsNot(type, code);
    }

}
