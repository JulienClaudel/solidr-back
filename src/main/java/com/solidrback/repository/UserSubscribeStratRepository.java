package com.solidrback.solidrback.repository;

import com.solidrback.solidrback.model.UserSubscribeStratDTO;
import com.solidrback.solidrback.model.entity.UserSubscribeStrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSubscribeStratRepository extends JpaRepository<UserSubscribeStrat, Integer> {
    // Find all the strategies followed by one user
    @Query("SELECT new com.solidrback.solidrback.model.UserSubscribeStratDTO(" +
            "u.strategyId," +
            "s.strategyLabel, " +
            "u.userEmail, " +
            "users.userUsername, " +
            "u.primeSolidr, " +
            "u.primeExpert," +
            "u.subscribeStratStartDate," +
            "u.subscribeStratEndDate," +
            "u.amountAffect1," +
            "u.symbolAffect1," +
            "u.amountAffect2," +
            "u.symbolAffect2) FROM UserSubscribeStrat u " +
            "LEFT JOIN Strategy s ON u.strategyId = s.strategyId " +
            "LEFT JOIN UserData users ON u.userEmail = users.userEmail " +
            "WHERE u.userEmail = ?1 ORDER BY u.subscribeStratStartDate")
    List<UserSubscribeStratDTO> findAllByUserEmail(String userEmail);

    // Find all the users followed by strategy
    @Query("SELECT new com.solidrback.solidrback.model.UserSubscribeStratDTO(" +
            "u.strategyId," +
            "s.strategyLabel, " +
            "u.userEmail, " +
            "users.userUsername, " +
            "u.primeSolidr, " +
            "u.primeExpert," +
            "u.subscribeStratStartDate," +
            "u.subscribeStratEndDate," +
            "u.amountAffect1," +
            "u.symbolAffect1," +
            "u.amountAffect2," +
            "u.symbolAffect2) FROM UserSubscribeStrat u " +
            "LEFT JOIN Strategy s ON u.strategyId = s.strategyId " +
            "LEFT JOIN UserData users ON u.userEmail = users.userEmail " +
            "WHERE u.strategyId = ?1 ORDER BY u.subscribeStratStartDate")
    List<UserSubscribeStratDTO> findAllByStrategyId(int strategyId);

    // Find all FOLLOWERS where EXPERT is
    @Query("SELECT new com.solidrback.solidrback.model.UserSubscribeStratDTO(" +
            "strat.strategyId," +
            "strat.strategyLabel, " +
            "sub.userEmail, " +
            "users.userUsername, " +
            "sub.primeSolidr, " +
            "sub.primeExpert," +
            "sub.subscribeStratStartDate," +
            "sub.subscribeStratEndDate," +
            "sub.amountAffect1," +
            "sub.symbolAffect1," +
            "sub.amountAffect2," +
            "sub.symbolAffect2) FROM Strategy strat " +
            "INNER JOIN UserSubscribeStrat sub ON strat.strategyId = sub.strategyId " +
            "LEFT JOIN UserData users ON sub.userEmail = users.userEmail " +
            "WHERE strat.userEmail = ?1 ORDER BY sub.subscribeStratStartDate")
    List<UserSubscribeStratDTO> findAllFollowersByExpert(String userEmail);

    // Find all FOLLOWERS by EXPERT'S ANGEL where EXPERT is
    @Query("SELECT new com.solidrback.solidrback.model.UserSubscribeStratDTO(" +
            "strat.strategyId," +
            "strat.strategyLabel, " +
            "sub.userEmail, " +
            "users.userUsername, " +
            "sub.primeSolidr, " +
            "sub.primeExpert," +
            "sub.subscribeStratStartDate," +
            "sub.subscribeStratEndDate," +
            "sub.amountAffect1," +
            "sub.symbolAffect1," +
            "sub.amountAffect2," +
            "sub.symbolAffect2) FROM Strategy strat " +
            "INNER JOIN UserSubscribeStrat sub ON strat.strategyId = sub.strategyId " +
            "LEFT JOIN UserData users ON sub.userEmail = users.userEmail " +
            "WHERE strat.strategyId = ?1 AND strat.userEmail = ?2" +
            "ORDER BY sub.subscribeStratStartDate")
    List<UserSubscribeStratDTO> findAllFollowersByAngelAndExpert(int strategyId, String userEmail);

    // Find all ANGELS FOLLOWED by one MEMBER
    @Query("SELECT new com.solidrback.solidrback.model.UserSubscribeStratDTO(" +
            "strat.strategyId," +
            "strat.strategyLabel, " +
            "sub.userEmail, " +
            "users.userUsername, " +
            "sub.primeSolidr, " +
            "sub.primeExpert," +
            "sub.subscribeStratStartDate," +
            "sub.subscribeStratEndDate," +
            "sub.amountAffect1," +
            "sub.symbolAffect1," +
            "sub.amountAffect2," +
            "sub.symbolAffect2) FROM Strategy strat " +
            "INNER JOIN UserSubscribeStrat sub ON strat.strategyId = sub.strategyId " +
            "LEFT JOIN UserData users ON sub.userEmail = users.userEmail " +
            "WHERE sub.userEmail = ?1 ORDER BY sub.subscribeStratStartDate")
    List<UserSubscribeStratDTO> findAllAngelsFollowedByUser(String userEmail);

    Boolean existsUserSubscribeStratByStrategyIdAndUserEmail(int strategyId, String userEmail);

    Boolean existsUserSubscribeStratByStrategyId(int strategyId);

}
