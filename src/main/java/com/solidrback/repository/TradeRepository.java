package com.solidrback.repository;

import com.solidrback.model.TradeDTO;
import com.solidrback.model.TradeMinDTO;
import com.solidrback.model.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Integer> {

    // Obligation to put a special query to match with the DTO model/service/impl
    @Query("SELECT new com.solidrback.model.TradeDTO(" +
            "t.tradeOrderlistid, " +
            "t.userEmail, " +
            "t.statusId, " +
            "t.tradePlatform," +
            "t.tradeAmountSymbol1," +
            "t.tradeAmountSymbol2, " +
            "t.tradePairLimit, " +
            "t.tradeAmountLimit," +
            "t.tradeSymbol," +
            "t.tradeClientorderlist," +
            "t.tradeTransactime," +
            "t.tradePrice," +
            "t.tradeOrigqty," +
            "t.tradeCummulativequoteqty," +
            "t.tradeStatus," +
            "t.tradeTimeinforce," +
            "t.tradeType," +
            "t.tradeSide," +
            "t.tradeCreationDate," +
            "t.tradeUpdateDate) FROM Trade t")
    List<TradeDTO> saveDTO(TradeDTO tradedto);

    @Query("SELECT new com.solidrback.model.TradeDTO(" +
            "t.tradeOrderlistid, " +
            "t.userEmail, " +
            "t.statusId, " +
            "t.tradePlatform," +
            "t.tradeAmountSymbol1," +
            "t.tradeAmountSymbol2, " +
            "t.tradePairLimit, " +
            "t.tradeAmountLimit," +
            "t.tradeSymbol," +
            "t.tradeClientorderlist," +
            "t.tradeTransactime," +
            "t.tradePrice," +
            "t.tradeOrigqty," +
            "t.tradeCummulativequoteqty," +
            "t.tradeStatus," +
            "t.tradeTimeinforce," +
            "t.tradeType," +
            "t.tradeSide," +
            "t.tradeCreationDate," +
            "t.tradeUpdateDate) FROM Trade t")
    List<TradeDTO> findAllTrades();

    @Query("SELECT new com.solidrback.model.TradeMinDTO(" +
            "t.tradeAmountSymbol1, " +
            "t.tradeAmountSymbol2," +
            "t.tradePrice, " +
            "t.tradeType, " +
            "t.tradeSide," +
            "t.tradeCreationDate) FROM Trade t")
    List<TradeMinDTO> findLittleListTrades();

    @Query("SELECT new com.solidrback.model.TradeDTO(" +
            "t.tradeOrderlistid, " +
            "t.userEmail, " +
            "t.statusId, " +
            "t.tradePlatform," +
            "t.tradeAmountSymbol1," +
            "t.tradeAmountSymbol2, " +
            "t.tradePairLimit, " +
            "t.tradeAmountLimit," +
            "t.tradeSymbol," +
            "t.tradeClientorderlist," +
            "t.tradeTransactime," +
            "t.tradePrice," +
            "t.tradeOrigqty," +
            "t.tradeCummulativequoteqty," +
            "t.tradeStatus," +
            "t.tradeTimeinforce," +
            "t.tradeType," +
            "t.tradeSide," +
            "t.tradeCreationDate," +
            "t.tradeUpdateDate) FROM Trade t WHERE t.userEmail = ?1")
    List<TradeDTO> findAllByUserEmail(String userEmail);

}
