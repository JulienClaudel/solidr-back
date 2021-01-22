package com.solidrback.model;

import java.time.LocalDate;

public class TradeMinDTO {
    private String tradeAmountSymbol1;
    private String tradeAmountSymbol2;
    private String tradePrice;
    private String tradeType;
    private String tradeSide;
    private LocalDate tradeCreationDate;

    public TradeMinDTO() {
    }

    public TradeMinDTO(String tradeAmountSymbol1, String tradeAmountSymbol2, String tradePrice, String tradeType, String tradeSide, LocalDate tradeCreationDate) {
        this.tradeAmountSymbol1 = tradeAmountSymbol1;
        this.tradeAmountSymbol2 = tradeAmountSymbol2;
        this.tradePrice = tradePrice;
        this.tradeType = tradeType;
        this.tradeSide = tradeSide;
        this.tradeCreationDate = tradeCreationDate;
    }

    public String getTradeAmountSymbol1() {
        return tradeAmountSymbol1;
    }

    public void setTradeAmountSymbol1(String tradeAmountSymbol1) {
        this.tradeAmountSymbol1 = tradeAmountSymbol1;
    }

    public String getTradeAmountSymbol2() {
        return tradeAmountSymbol2;
    }

    public void setTradeAmountSymbol2(String tradeAmountSymbol2) {
        this.tradeAmountSymbol2 = tradeAmountSymbol2;
    }

    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeSide() {
        return tradeSide;
    }

    public void setTradeSide(String tradeSide) {
        this.tradeSide = tradeSide;
    }

    public LocalDate getTradeCreationDate() {
        return tradeCreationDate;
    }

    public void setTradeCreationDate(LocalDate tradeCreationDate) {
        this.tradeCreationDate = tradeCreationDate;
    }
}
