package com.solidrback.controller;

import com.solidrback.exception.ResourceNotFoundException;
import com.solidrback.model.entity.TablePrice;
import com.solidrback.repository.TablePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tableprices")
public class TablePriceController {

    @Autowired
    private TablePriceRepository tablePriceRepository;

    @GetMapping("/")
    public List<TablePrice> getAllTablePrices() {
        return tablePriceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablePrice> getTablePriceById(@PathVariable(value = "id") Long tablePriceId) throws ResourceNotFoundException {
        TablePrice tablePrice = tablePriceRepository.findById(tablePriceId).orElseThrow(() -> new ResourceNotFoundException("TablePrice not found for this id::" + tablePriceId));
        return ResponseEntity.ok().body( tablePrice );
    }

    @PreAuthorize("hasRole('Staff')")
    @PostMapping("/")
    public TablePrice createTablePrice(@Valid @RequestBody TablePrice tablePrice) {
        return tablePriceRepository.save(tablePrice);
    }

    @PreAuthorize("hasRole('Staff')")
    @PutMapping("/tableprices/{id}")
    public ResponseEntity<TablePrice> updateTablePrice(@PathVariable(value = "id") Long tablePriceId, @Valid @RequestBody TablePrice tablePriceDetails) throws ResourceNotFoundException {
        TablePrice tablePrice = tablePriceRepository.findById(tablePriceId).orElseThrow(() -> new ResourceNotFoundException("TablePrice not found for this id::" + tablePriceId));

        tablePrice.setTablePricePeriod(tablePriceDetails.getTablePricePeriod());
        tablePrice.setTablePriceAmount(tablePriceDetails.getTablePriceAmount());
        tablePrice.setTablePriceText1(tablePriceDetails.getTablePriceText1());
        tablePrice.setTablePriceText2(tablePriceDetails.getTablePriceText2());
        tablePrice.setTablePriceText3(tablePriceDetails.getTablePriceText3());
        tablePrice.setTablePriceText4(tablePriceDetails.getTablePriceText4());
        final TablePrice updateTablePrice = tablePriceRepository.save(tablePrice);
        return ResponseEntity.ok(updateTablePrice);
    }

    @PreAuthorize("hasRole('Staff')")
    @DeleteMapping("/tableprices/{id}")
    public Map<String, Boolean> deleteTablePrice (@PathVariable(value = "id") Long tablePriceId) throws
            ResourceNotFoundException {
        TablePrice tablePrice = tablePriceRepository.findById(tablePriceId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + tablePriceId));

        tablePriceRepository.delete(tablePrice);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;


    }


}
