package com.solidrback.service;

import com.solidrback.client.domain.TimeInForce;
import com.solidrback.client.domain.account.NewOrderResponse;
import com.solidrback.model.TradeDTO;
import com.solidrback.model.TradeMinDTO;
import com.solidrback.model.entity.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeService {

    List<TradeDTO> findAllTrades();

    Optional<Trade> findTradeById(int tradeId);

    List<TradeMinDTO> findLittleListTrades();

    List<TradeDTO> findAllTradesByUserEmail(String userEmail);

    Trade save(Trade trade);

    NewOrderResponse saveBuy(String symbol, TimeInForce timeInForce, String quantity, String price);

    NewOrderResponse saveSell(String symbol, TimeInForce timeInForce, String quantity, String price);


}
