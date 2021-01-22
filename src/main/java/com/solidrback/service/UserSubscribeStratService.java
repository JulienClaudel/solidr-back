package com.solidrback.service;

import com.solidrback.model.UserSubscribeStratDTO;
import com.solidrback.model.entity.UserSubscribeStrat;

import java.util.List;

public interface UserSubscribeStratService {

    List<UserSubscribeStratDTO> findAllByStrategyId(int strategyId);

    List<UserSubscribeStratDTO> findAllByUserEmail(String userEmail);

    UserSubscribeStrat save(UserSubscribeStrat userSubscribeStrat);

    // Find all FOLLOWERS where EXPERT is
    List<UserSubscribeStratDTO> findAllFollowersByExpert(String userEmail);

    // Find all FOLLOWERS by EXPERT'S ANGEL where EXPERT is
    List<UserSubscribeStratDTO> findAllFollowersByAngelAndExpert(int strategyId, String userEmail);

    // Find all ANGELS FOLLOWED by one MEMBER
    List<UserSubscribeStratDTO> findAllAngelsFollowedByUser(String userEmail);
}
