package com.solidrback.repository;

import com.solidrback.enums.Interval;
import com.solidrback.enums.Limit;
import com.solidrback.enums.Symbol;
import com.solidrback.model.CandleCollect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandleCollectRepository {

    void deleteBySymbolAndInterval(Symbol symbol, Interval interval);


    List<CandleCollect> findWithinTime(Symbol symbol, Interval interval, Long greater, Long less);


    Page<CandleCollect> findBySymbolAndIntervalOrderByOpenTime(Symbol symbol, Interval interval, Pageable pageRequest);


    List<CandleCollect> findAllForSymbolAndInterval(Symbol symbol, Interval interval, Limit limit);
}
