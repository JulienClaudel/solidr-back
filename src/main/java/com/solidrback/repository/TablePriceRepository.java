package com.solidrback.repository;

import com.solidrback.model.entity.TablePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablePriceRepository extends JpaRepository <TablePrice, Long> {

}
