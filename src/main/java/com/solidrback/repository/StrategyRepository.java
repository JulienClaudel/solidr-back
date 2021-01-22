package com.solidrback.solidrback.repository;

import com.solidrback.solidrback.model.StrategyDTO;
import com.solidrback.solidrback.model.entity.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StrategyRepository extends JpaRepository<Strategy, Integer> {
    @Query("SELECT new com.solidrback.solidrback.model.StrategyDTO(" +
            "s.strategyId, " +
            "s.userEmail, " +
            "s.statusId, " +
            "s.strategyLabel," +
            "s.strategyDescription," +
            "s.strategySymbol1, " +
            "s.strategySymbol2, " +
            "s.strategyPrime," +
            "s.strategyCreationDate," +
            "s.strategyUpdateDate," +
            "s.strategyIcon," +
            "s.strategyProfitability) FROM Strategy s WHERE NOT s.statusId = 11")
    List<StrategyDTO> findAllStrat();

    @Query("SELECT new com.solidrback.solidrback.model.StrategyDTO(" +
            "s.strategyId, " +
            "s.userEmail, " +
            "s.statusId, " +
            "s.strategyLabel," +
            "s.strategyDescription," +
            "s.strategySymbol1, " +
            "s.strategySymbol2, " +
            "s.strategyPrime," +
            "s.strategyCreationDate," +
            "s.strategyUpdateDate," +
            "s.strategyIcon," +
            "s.strategyProfitability) FROM Strategy s  WHERE s.strategyId = ?1")
    Optional<StrategyDTO> findStratById(Integer strategyId);

    @Query("SELECT new com.solidrback.solidrback.model.StrategyDTO(" +
            "s.strategyId, " +
            "s.userEmail, " +
            "s.statusId, " +
            "s.strategyLabel," +
            "s.strategyDescription," +
            "s.strategySymbol1, " +
            "s.strategySymbol2, " +
            "s.strategyPrime," +
            "s.strategyCreationDate," +
            "s.strategyUpdateDate," +
            "s.strategyIcon," +
            "s.strategyProfitability) FROM Strategy s  WHERE s.userEmail = ?1 AND NOT s.statusId = 11")
    Optional<StrategyDTO> findByUserEmail(String userEmail);

    @Query("SELECT new com.solidrback.solidrback.model.StrategyDTO(" +
            "s.strategyId, " +
            "s.userEmail, " +
            "s.statusId, " +
            "s.strategyLabel," +
            "s.strategyDescription," +
            "s.strategySymbol1, " +
            "s.strategySymbol2, " +
            "s.strategyPrime," +
            "s.strategyCreationDate," +
            "s.strategyUpdateDate," +
            "s.strategyIcon," +
            "s.strategyProfitability) FROM Strategy s  WHERE s.userEmail = ?1 AND NOT s.statusId = 11")
    List<StrategyDTO> findAllByUserEmail(String userEmail);

    @Query("SELECT new com.solidrback.solidrback.model.StrategyDTO(" +
            "s.strategyId, " +
            "s.userEmail, " +
            "s.statusId, " +
            "s.strategyLabel," +
            "s.strategyDescription," +
            "s.strategySymbol1, " +
            "s.strategySymbol2, " +
            "s.strategyPrime," +
            "s.strategyCreationDate," +
            "s.strategyUpdateDate," +
            "s.strategyIcon," +
            "s.strategyProfitability) FROM Strategy s  WHERE NOT s.userEmail = ?1 AND NOT s.statusId = 11")
    List<StrategyDTO> findAllOtherStrategies(String userEmail);

    @Query("SELECT new com.solidrback.solidrback.model.StrategyDTO(" +
            "s.strategyId, " +
            "s.userEmail, " +
            "s.statusId, " +
            "s.strategyLabel," +
            "s.strategyDescription," +
            "s.strategySymbol1, " +
            "s.strategySymbol2, " +
            "s.strategyPrime," +
            "s.strategyCreationDate," +
            "s.strategyUpdateDate," +
            "s.strategyIcon," +
            "s.strategyProfitability) FROM Strategy s  WHERE s.strategyId = ?1")
    Optional<StrategyDTO> save(Integer strategyId);

    Boolean existsStrategyByStrategyLabel(String strategyLabel);

    Boolean existsStrategyByUserEmail(String userEmail);

    Optional<Strategy> findByStrategyId(Integer strategyId);
}
