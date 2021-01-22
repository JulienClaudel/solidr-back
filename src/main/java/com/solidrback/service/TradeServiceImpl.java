package com.solidrback.solidrback.service;

import com.solidrback.solidrback.client.BinanceApiClientFactory;
import com.solidrback.solidrback.client.BinanceApiRestClient;
import com.solidrback.solidrback.client.domain.TimeInForce;
import com.solidrback.solidrback.client.domain.account.NewOrderResponse;
import com.solidrback.solidrback.client.domain.account.NewOrderResponseType;
import com.solidrback.solidrback.configuration.TradeConfiguration;
import com.solidrback.solidrback.model.TradeDTO;
import com.solidrback.solidrback.model.TradeMinDTO;
import com.solidrback.solidrback.model.entity.Trade;
import com.solidrback.solidrback.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.solidrback.solidrback.client.domain.account.NewOrder.limitBuy;
import static com.solidrback.solidrback.client.domain.account.NewOrder.limitSell;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeServiceImpl implements TradeService {

    private final TradeConfiguration tradeConfiguration;
    //String key = tradeConfiguration.getTradeApiKey();
    //String secret = tradeConfiguration.getTradeApiSecret();

    BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("zQPGUczadeCjgdkmgkg6pz2HzuikG04GR1GHOD8D4Mrk3H32Gq2FgTSe3xxb1L0q", "m8Cb6PGYExkemoHiQogKBjz3et7QiydzMfBCzLE55UGUugqvK0UjHMUtF8DQiILq");
    BinanceApiRestClient client = factory.newRestClient();


    @Autowired
    TradeRepository tradeRepository;

    @Override
    public Optional<Trade> findTradeById(int tradeId) {
        return tradeRepository.findById(tradeId);
    }

    @Override
    public List<TradeMinDTO> findLittleListTrades() {
        return tradeRepository.findLittleListTrades();
    }

    @Override
    public List<TradeDTO> findAllTradesByUserEmail(String userEmail) {
        return tradeRepository.findAllByUserEmail(userEmail);
    }

    @Override
    public List<TradeDTO> findAllTrades() {
        return tradeRepository.findAllTrades();
    }

    @Override
    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public NewOrderResponse saveBuy(String symbol, TimeInForce timeInForce, String quantity, String price) {
        NewOrderResponse newOrderResponse = client.newOrder(limitBuy(symbol, TimeInForce.GTC, quantity, price).newOrderRespType(NewOrderResponseType.FULL));
        System.out.println(newOrderResponse);
/*
        if (newOrderResponse == null) {
            log.warn("No response from service!");
            return new ArrayList<>();
        }
*/
        return newOrderResponse;
    }

    @Override
    public NewOrderResponse saveSell(String symbol, TimeInForce timeInForce, String quantity, String price) {
        NewOrderResponse newOrderResponse = client.newOrder(limitSell(symbol, TimeInForce.GTC, quantity, price).newOrderRespType(NewOrderResponseType.FULL));
        System.out.println(newOrderResponse);
        return newOrderResponse;
    }

}
