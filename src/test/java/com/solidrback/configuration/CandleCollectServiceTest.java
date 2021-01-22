package com.solidrback.configuration;

import com.solidrback.enums.Interval;
import com.solidrback.enums.Limit;
import com.solidrback.enums.Symbol;
import com.solidrback.model.CandleCollect;
import com.solidrback.service.CandleCollectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class CandleCollectServiceTest {

    @Autowired
    CandleCollectService candleCollectService;

    @Test
    public void extractCandles() {

        List<CandleCollect> candleCollects = candleCollectService.extractCandles(
                Symbol.BTCUSDT,
                Interval.FIFTEEN_MIN,
                Limit.CINQCENT);
        Assertions.assertTrue(candleCollects.size() > 0);
        candleCollects.forEach(e -> {
            System.out.println(e.simpleToString());
        });
    }
}
