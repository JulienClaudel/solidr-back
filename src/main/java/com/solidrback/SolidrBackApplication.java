package com.solidrback;

import com.solidrback.configuration.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({CandleCollectConfiguration.class, TradeConfiguration.class})
public class SolidrBackApplication {

    public static void main(String[] args) {

        SpringApplication.run(SolidrBackApplication.class, args);


    }




}

