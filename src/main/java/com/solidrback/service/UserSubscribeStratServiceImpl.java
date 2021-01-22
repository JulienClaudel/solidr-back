package com.solidrback.service;

import com.solidrback.model.UserSubscribeStratDTO;
import com.solidrback.model.entity.UserSubscribeStrat;
import com.solidrback.repository.UserSubscribeStratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSubscribeStratServiceImpl implements UserSubscribeStratService {
    @Autowired
    UserSubscribeStratRepository userSubscribeRepository;

    @Override
    public List<UserSubscribeStratDTO> findAllByStrategyId(int strategyId) {
        return userSubscribeRepository.findAllByStrategyId(strategyId);
    }

    @Override
    public List<UserSubscribeStratDTO> findAllByUserEmail(String userEmail) {
        return userSubscribeRepository.findAllByUserEmail(userEmail);
    }

    @Override
    public UserSubscribeStrat save(UserSubscribeStrat userSubscribeStrat) {
        return userSubscribeRepository.save(userSubscribeStrat);
    }

    @Override
    public List<UserSubscribeStratDTO> findAllFollowersByExpert(String userEmail) {
        return userSubscribeRepository.findAllFollowersByExpert(userEmail);
    }

    @Override
    public List<UserSubscribeStratDTO> findAllFollowersByAngelAndExpert(int strategyId, String userEmail) {
        return userSubscribeRepository.findAllFollowersByAngelAndExpert(strategyId, userEmail);
    }

    @Override
    public List<UserSubscribeStratDTO> findAllAngelsFollowedByUser(String userEmail) {
        return userSubscribeRepository.findAllAngelsFollowedByUser(userEmail);
    }
}
