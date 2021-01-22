package com.solidrback.solidrback.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;

public class TradeDTO {
    private int tradeOrderlistid;
    private String userEmail;
    private int statusId;
    private String tradePlatform;
    private String tradeAmountSymbol1;
    private String tradeAmountSymbol2;
    private String tradePairLimit;
    private String tradeAmountLimit;
    private String tradeSymbol;
    private String tradeClientorderlist;
    private BigInteger tradeTransactime;
    private String tradePrice;
    private String tradeOrigqty;
    private String tradeCummulativequoteqty;
    private String tradeStatus;
    private String tradeTimeinforce;
    private String tradeType;
    private String tradeSide;
    private LocalDate tradeCreationDate;
    private LocalDate tradeUpdateDate;

    public TradeDTO() { }

    public TradeDTO(int tradeOrderlistid, String userEmail, int statusId, String tradePlatform,
                    String tradeAmountSymbol1, String tradeAmountSymbol2, String tradePairLimit, String tradeAmountLimit,
                    String tradeSymbol, String tradeClientorderlist, BigInteger tradeTransactime, String tradePrice,
                    String tradeOrigqty, String tradeCummulativequoteqty, String tradeStatus, String tradeTimeinforce,
                    String tradeType, String tradeSide, LocalDate tradeCreationDate, LocalDate tradeUpdateDate) {
        this.tradeOrderlistid = tradeOrderlistid;
        this.userEmail = userEmail;
        this.statusId = statusId;
        this.tradePlatform = tradePlatform;
        this.tradeAmountSymbol1 = tradeAmountSymbol1;
        this.tradeAmountSymbol2 = tradeAmountSymbol2;
        this.tradePairLimit = tradePairLimit;
        this.tradeAmountLimit = tradeAmountLimit;
        this.tradeSymbol = tradeSymbol;
        this.tradeClientorderlist = tradeClientorderlist;
        this.tradeTransactime = tradeTransactime;
        this.tradePrice = tradePrice;
        this.tradeOrigqty = tradeOrigqty;
        this.tradeCummulativequoteqty = tradeCummulativequoteqty;
        this.tradeStatus = tradeStatus;
        this.tradeTimeinforce = tradeTimeinforce;
        this.tradeType = tradeType;
        this.tradeSide = tradeSide;
        this.tradeCreationDate = tradeCreationDate;
        this.tradeUpdateDate = tradeUpdateDate;
    }

    public int getTradeOrderlistid() {
        return tradeOrderlistid;
    }

    public void setTradeOrderlistid(int tradeOrderlistid) {
        this.tradeOrderlistid = tradeOrderlistid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getTradePlatform() {
        return tradePlatform;
    }

    public void setTradePlatform(String tradePlatform) {
        this.tradePlatform = tradePlatform;
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

    public String getTradePairLimit() {
        return tradePairLimit;
    }

    public void setTradePairLimit(String tradePairLimit) {
        this.tradePairLimit = tradePairLimit;
    }

    public String getTradeAmountLimit() {
        return tradeAmountLimit;
    }

    public void setTradeAmountLimit(String tradeAmountLimit) {
        this.tradeAmountLimit = tradeAmountLimit;
    }

    public String getTradeSymbol() {
        return tradeSymbol;
    }

    public void setTradeSymbol(String tradeSymbol) {
        this.tradeSymbol = tradeSymbol;
    }

    public String getTradeClientorderlist() {
        return tradeClientorderlist;
    }

    public void setTradeClientorderlist(String tradeClientorderlist) {
        this.tradeClientorderlist = tradeClientorderlist;
    }

    public BigInteger getTradeTransactime() {
        return tradeTransactime;
    }

    public void setTradeTransactime(BigInteger tradeTransactime) {
        this.tradeTransactime = tradeTransactime;
    }

    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getTradeOrigqty() {
        return tradeOrigqty;
    }

    public void setTradeOrigqty(String tradeOrigqty) {
        this.tradeOrigqty = tradeOrigqty;
    }

    public String getTradeCummulativequoteqty() {
        return tradeCummulativequoteqty;
    }

    public void setTradeCummulativequoteqty(String tradeCummulativequoteqty) {
        this.tradeCummulativequoteqty = tradeCummulativequoteqty;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeTimeinforce() {
        return tradeTimeinforce;
    }

    public void setTradeTimeinforce(String tradeTimeinforce) {
        this.tradeTimeinforce = tradeTimeinforce;
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

    public LocalDate getTradeUpdateDate() {
        return tradeUpdateDate;
    }

    public void setTradeUpdateDate(LocalDate tradeUpdateDate) {
        this.tradeUpdateDate = tradeUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeDTO tradeDTO = (TradeDTO) o;
        return tradeOrderlistid == tradeDTO.tradeOrderlistid &&
                userEmail.equals(tradeDTO.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeOrderlistid, userEmail);
    }
}
