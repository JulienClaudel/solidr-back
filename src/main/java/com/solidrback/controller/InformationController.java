package com.solidrback.controller;

import com.solidrback.model.entity.Information;
import com.solidrback.repository.InformationRepository;
import com.solidrback.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/informations")
public class InformationController {
    @Autowired
    InformationService informationService;

    @Autowired
    InformationRepository informationRepository;

    @GetMapping("/")
    public List<Information> getAllInformations() {
        return informationService.findAll();
    }

    @GetMapping("/{type}")
    public List<Information> getAllSymbols(@PathVariable(value = "type") String type) {
        return informationRepository.findAllByInformationTypeEquals(type);
    }

    @GetMapping("/{type}/{code}")
    public List<Information> getAllSymbolsExceptCode(@PathVariable String type, @PathVariable String code) {
        return informationRepository.findAllByInformationTypeEqualsAndInformationCodeIsNot(type, code);
    }

}
