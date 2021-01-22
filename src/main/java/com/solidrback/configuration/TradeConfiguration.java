package com.solidrback.solidrback.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("trade")
@Data
public class TradeConfiguration {
    private String tradeUrlPrefix;
    private String tradeUrl;
    private String tradeUrlQuerySymbol;
    private String tradeUrlQuerySide;
    private String tradeUrlQueryType;
    private String tradeUrlQueryTimeInForce;
    private String tradeUrlQueryQuantity;
    private String tradeUrlQueryPrice;
    private String tradeUrlQueryNewClientOrderId;
    private String tradeUrlQueryTimestamp;
    private String tradeUrlQuerySignature;
    private String tradeApiKey;
    private String tradeApiSecret;

}