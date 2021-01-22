package com.solidrback.controller;

import com.solidrback.client.domain.TimeInForce;
import com.solidrback.client.domain.account.NewOrderResponse;
import com.solidrback.model.TradeDTO;
import com.solidrback.model.TradeMinDTO;
import com.solidrback.model.entity.Trade;
import com.solidrback.service.EmailSenderService;
import com.solidrback.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/trades")
public class TradeController {
    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    TradeService tradeService;

    /// Get all trades with Entity model
    @GetMapping("/")
    public List<TradeDTO> findAllTrades() {
        return tradeService.findAllTrades();
    }

    /// Get all trade with MinDTO model
    @GetMapping("/min")
    public List<TradeMinDTO> findLittleListTrades() {
        return tradeService.findLittleListTrades();
    }

    /// Find one trade by Id
    @GetMapping("/{id}")
    public ResponseEntity<Trade> findTradeById(@PathVariable(value = "id") int tradeId) {
        Optional<Trade> trade = tradeService.findTradeById(tradeId);
        if (trade.isPresent()) {
            return ResponseEntity.ok().body(trade.get());
        }
        return (ResponseEntity<Trade>) ResponseEntity.notFound();
    }

    /// Find all trades by userEmail
    @GetMapping("/email/{email}")
    public List<TradeDTO> findAllTradesByUserEmail(@PathVariable(value = "email") String userEmail) {
        List<TradeDTO> trades = tradeService.findAllTradesByUserEmail(userEmail);
        return trades;
    }

    /// Save a new Trade in the database
    @PostMapping("/")
    public ResponseEntity<Trade> createTrade(@Valid @RequestBody Trade trade) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(trade.getUserEmail());
        mailMessage.setSubject("Order taken!");
        mailMessage.setFrom("sldr.solidr@gmail.com");
        mailMessage.setText("A " + trade.getTradeSide() + " of " + trade.getTradeOrigqty() + " " + trade.getTradeSymbol() + " has been taken for you!");

        emailSenderService.sendEmail(mailMessage);
        return ResponseEntity.ok().body(tradeService.save(trade));
    }

    /// Send a Trade - Limit BUY - to Binance
    @PostMapping("/buy/{symbol}/{timeInForceBeforeConvertion}/{quantity}/{price}")
    public NewOrderResponse createBuyTrade(
            // @PathVariable String symbolBeforeConvertion,
            @PathVariable String symbol,
            @PathVariable String timeInForceBeforeConvertion,
            @PathVariable String quantity,
            @PathVariable String price) {

        // Symbol symbol = Symbol.valueOf(symbolBeforeConvertion);
        TimeInForce timeInForce = TimeInForce.valueOf(timeInForceBeforeConvertion);

        NewOrderResponse newOrderResponse = tradeService.saveBuy(symbol, timeInForce, quantity, price);
/*
            Assertions.assertTrue(newOrderResponse.size() > 0);
        newOrderResponse.forEach(e -> {
                System.out.println(e);
            });
*/
        return newOrderResponse;
    }

    /// Send a Trade - Limit SELL - to Binance
    @PostMapping("/sell/{symbol}/{timeInForceBeforeConvertion}/{quantity}/{price}")
    public NewOrderResponse createSellTrade(
            // @PathVariable String symbolBeforeConvertion,
            @PathVariable String symbol,
            @PathVariable String timeInForceBeforeConvertion,
            @PathVariable String quantity,
            @PathVariable String price) {

        // Symbol symbol = Symbol.valueOf(symbolBeforeConvertion);
        TimeInForce timeInForce = TimeInForce.valueOf(timeInForceBeforeConvertion);

        NewOrderResponse newOrderResponse = tradeService.saveSell(symbol, timeInForce, quantity, price);

        return newOrderResponse;
    }

    /// Update one Trade by Id
    @PutMapping("/{id}")
    public ResponseEntity<Trade> updateTrade(@Valid @RequestBody Trade trade) {
        return ResponseEntity.ok().body(tradeService.save(trade));
    }
}
