package com.solidrback.enums;

import lombok.Getter;

@Getter
public enum Symbol {
    BTCUSDT("BTCUSDT"),
    LTCUSDT("LTCUSDT"),
    BNBBUSD("BNBBUSD"),
    BTCBUSD("BTCBUSD"),
    ETHBUSD("ETHBUSD"),
    LTCBUSD("LTCBUSD"),
    TRXBUSD("TRXBUSD"),
    XRPBUSD("XRPBUSD"),
    BNBUSDT("BNBUSDT"),
    ETHUSDT("ETHUSDT"),
    TRXUSDT("TRXUSDT"),
    XRPUSDT("XRPUSDT"),
    BNBBTC("BNBBTC"),
    ETHBTC("ETHBTC"),
    LTCBTC("LTCBTC"),
    TRXBTC("TRXBTC"),
    XRPBTC("XRPBTC"),
    LTCBNB("LTCBNB"),
    TRXBNB("TRXBNB"),
    XRPBNB("XRPBNB");
    private String code;

    Symbol(String code) {
        this.code = code;
    }
}
