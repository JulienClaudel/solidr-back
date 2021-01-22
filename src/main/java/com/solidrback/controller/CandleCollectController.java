package com.solidrback.controller;


import com.solidrback.enums.Interval;
import com.solidrback.enums.Limit;
import com.solidrback.enums.Symbol;
import com.solidrback.model.CandleCollect;
import com.solidrback.service.CandleCollectService;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/candlecollect")
public class CandleCollectController {

    @Autowired
    CandleCollectService candleCollectService;


    @GetMapping("/{symbolBeforeConvertion}/{intervalBeforeConvertion}/{limitBeforeConvertion}")
    public List<CandleCollect> findCandleCollectBySymbol(
            @PathVariable String symbolBeforeConvertion,
            @PathVariable String intervalBeforeConvertion,
            @PathVariable String limitBeforeConvertion) {

        Symbol symbol = Symbol.valueOf(symbolBeforeConvertion);
        Interval interval = Interval.valueOf(intervalBeforeConvertion);
        Limit limit = Limit.valueOf(limitBeforeConvertion);


        List<CandleCollect> candleCollects = candleCollectService.extractCandles(symbol, interval, limit);

        Assertions.assertTrue(candleCollects.size() > 0);
        /*candleCollects.forEach(e -> {
            System.out.println(e.simpleToString());
        });*/

        return candleCollects;

    }
}

