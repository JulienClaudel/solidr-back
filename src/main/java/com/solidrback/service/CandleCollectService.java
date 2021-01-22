package com.solidrback.solidrback.service;


import com.solidrback.solidrback.configuration.CandleCollectConfiguration;
import com.solidrback.solidrback.enums.Interval;
import com.solidrback.solidrback.enums.Limit;
import com.solidrback.solidrback.enums.Symbol;
import com.solidrback.solidrback.model.CandleCollect;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandleCollectService {
    private final CandleCollectConfiguration candleCollectConfiguration;



    public List<CandleCollect> extractCandles(Symbol symbol, Interval interval, Limit limit) {
        //log.info("Extract candles: symbol {} interval {} limit {}", symbol, interval, limit);
        RestTemplate rt = new RestTemplate();

        URI url = UriComponentsBuilder.fromHttpUrl(candleCollectConfiguration.getCandleUrlPrefix()
                + candleCollectConfiguration.getCandleUrl())

                .queryParam(candleCollectConfiguration.getCandleUrlQuerySymbol(),
                        symbol.getCode())

                .queryParam(candleCollectConfiguration.getCandleUrlQueryInterval(),
                        interval.getCode())

                .queryParam(candleCollectConfiguration.getCandleUrlQueryLimit(), limit.getCode())
                .build().toUri();

        //log.debug("Url: {}", url);
        ResponseEntity<List<List<Object>>> exchange = rt.exchange(new RequestEntity<>(HttpMethod.GET, url),
                new ParameterizedTypeReference<>() {  });

        List<List<Object>> response = exchange.getBody();
        if (response == null) {
            log.warn("No response from service!");
            return new ArrayList<>();
        }

        List<CandleCollect> collect = response.stream()
                .map(l -> CandleCollect.fromArray(l, symbol, interval))
                .collect(Collectors.toList());
        //log.info("items extracted: {}", collect.size());
        return collect;
    }


}
