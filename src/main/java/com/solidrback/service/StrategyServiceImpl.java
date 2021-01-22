package com.solidrback.service;

import com.solidrback.model.StrategyDTO;
import com.solidrback.model.entity.Strategy;
import com.solidrback.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    StrategyRepository strategyRepository;

    @Override
    public List<Strategy> findAll() {
        return strategyRepository.findAll();
    }

    @Override
    public List<StrategyDTO> findAllStrat() {
        return strategyRepository.findAllStrat();
    }

    @Override
    public List<StrategyDTO> findAllStratByUserEmail(String userEmail) {
        return strategyRepository.findAllByUserEmail(userEmail);
    }

    @Override
    public List<StrategyDTO> findAllOtherStrategies(String userEmail) {
        return strategyRepository.findAllOtherStrategies(userEmail);
    }

    @Override
    public Optional<Strategy> findStrategyById(int strategyId) {
        return strategyRepository.findById(strategyId);
    }

    @Override
    public Optional<Strategy> findById(Integer strategyId) {
        return strategyRepository.findById(strategyId);
    }
    

    @Override
    public Strategy save(Strategy strategy) {
        return strategyRepository.save(strategy);
    }

}
