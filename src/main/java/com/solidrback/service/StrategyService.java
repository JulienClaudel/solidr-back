package com.solidrback.solidrback.service;

import com.solidrback.solidrback.model.StrategyDTO;
import com.solidrback.solidrback.model.entity.Strategy;

import java.util.List;
import java.util.Optional;

public interface StrategyService {

    List<Strategy> findAll();

    List<StrategyDTO> findAllStrat();

    List<StrategyDTO> findAllStratByUserEmail(String userEmail);

    List<StrategyDTO> findAllOtherStrategies(String userEmail);

    Optional<Strategy> findStrategyById(int strategyId);

    Optional<Strategy> findById(Integer strategyId);

    Strategy save(Strategy strategy);
}
