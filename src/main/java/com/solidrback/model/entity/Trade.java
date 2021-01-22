package com.solidrback.model.entity;

import com.solidrback.enums.Side;
import com.solidrback.enums.Symbol;
import com.solidrback.enums.TimeInForce;
import com.solidrback.enums.Type;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Trade {
    private Symbol symbol;
    private Side side;
    private Type type;
    private TimeInForce timeInForce;

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
    private UserData userDataByUserEmail;
    private Status statusByStatusId;



    public Trade() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRADE_ORDERLISTID", nullable = false, precision = 0)
    public int getTradeOrderlistid() {
        return tradeOrderlistid;
    }

    public void setTradeOrderlistid(int tradeOrderlistid) {
        this.tradeOrderlistid = tradeOrderlistid;
    }

    @Basic
    @Column(name = "USER_EMAIL", nullable = false, length = 60)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "STATUS_ID", nullable = false, precision = 0)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "TRADE_PLATFORM", nullable = false, length = 50)
    public String getTradePlatform() {
        return tradePlatform;
    }

    public void setTradePlatform(String tradePlatform) {
        this.tradePlatform = tradePlatform;
    }

    @Basic
    @Column(name = "TRADE_AMOUNT_SYMBOL1", nullable = true, precision = 50)
    public String getTradeAmountSymbol1() {
        return tradeAmountSymbol1;
    }

    public void setTradeAmountSymbol1(String tradeAmountSymbol1) {
        this.tradeAmountSymbol1 = tradeAmountSymbol1;
    }

    @Basic
    @Column(name = "TRADE_AMOUNT_SYMBOL2", nullable = true, precision = 50)
    public String getTradeAmountSymbol2() {
        return tradeAmountSymbol2;
    }

    public void setTradeAmountSymbol2(String tradeAmountSymbol2) {
        this.tradeAmountSymbol2 = tradeAmountSymbol2;
    }

    @Basic
    @Column(name = "TRADE_PAIR_LIMIT", nullable = true, precision = 50)
    public String getTradePairLimit() {
        return tradePairLimit;
    }

    public void setTradePairLimit(String tradePairLimit) {
        this.tradePairLimit = tradePairLimit;
    }

    @Basic
    @Column(name = "TRADE_AMOUNT_LIMIT", nullable = true, precision = 50)
    public String getTradeAmountLimit() {
        return tradeAmountLimit;
    }

    public void setTradeAmountLimit(String tradeAmountLimit) {
        this.tradeAmountLimit = tradeAmountLimit;
    }

    @Basic
    @Column(name = "TRADE_SYMBOL", nullable = true, length = 30)
    public String getTradeSymbol() {
        return tradeSymbol;
    }

    public void setTradeSymbol(String tradeSymbol) {
        this.tradeSymbol = tradeSymbol;
    }

    @Basic
    @Column(name = "TRADE_CLIENTORDERLIST", nullable = true, length = 50)
    public String getTradeClientorderlist() {
        return tradeClientorderlist;
    }

    public void setTradeClientorderlist(String tradeClientorderlist) {
        this.tradeClientorderlist = tradeClientorderlist;
    }

    @Basic
    @Column(name = "TRADE_TRANSACTIME", nullable = true)
    public BigInteger getTradeTransactime() {
        return tradeTransactime;
    }

    public void setTradeTransactime(BigInteger tradeTransactime) {
        this.tradeTransactime = tradeTransactime;
    }

    @Basic
    @Column(name = "TRADE_PRICE", nullable = true, length = 50)
    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    @Basic
    @Column(name = "TRADE_ORIGQTY", nullable = true, length = 50)
    public String getTradeOrigqty() {
        return tradeOrigqty;
    }

    public void setTradeOrigqty(String tradeOrigqty) {
        this.tradeOrigqty = tradeOrigqty;
    }

    @Basic
    @Column(name = "TRADE_CUMMULATIVEQUOTEQTY", nullable = true, length = 50)
    public String getTradeCummulativequoteqty() {
        return tradeCummulativequoteqty;
    }

    public void setTradeCummulativequoteqty(String tradeCummulativequoteqty) {
        this.tradeCummulativequoteqty = tradeCummulativequoteqty;
    }

    @Basic
    @Column(name = "TRADE_STATUS", nullable = true, length = 50)
    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Basic
    @Column(name = "TRADE_TIMEINFORCE", nullable = true, length = 50)
    public String getTradeTimeinforce() {
        return tradeTimeinforce;
    }

    public void setTradeTimeinforce(String tradeTimeinforce) {
        this.tradeTimeinforce = tradeTimeinforce;
    }

    @Basic
    @Column(name = "TRADE_TYPE", nullable = true, length = 50)
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Basic
    @Column(name = "TRADE_SIDE", nullable = true, length = 50)
    public String getTradeSide() {
        return tradeSide;
    }

    public void setTradeSide(String tradeSide) {
        this.tradeSide = tradeSide;
    }

    @Basic
    @Column(name = "TRADE_CREATION_DATE", nullable = false)
    public LocalDate getTradeCreationDate() {
        return tradeCreationDate;
    }

    public void setTradeCreationDate(LocalDate tradeCreationDate) {
        this.tradeCreationDate = tradeCreationDate;
    }

    @Basic
    @Column(name = "TRADE_UPDATE_DATE", nullable = false)
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
        Trade trade = (Trade) o;
        return Objects.equals(tradeOrderlistid, trade.tradeOrderlistid) &&
                Objects.equals(userEmail, trade.userEmail) &&
                Objects.equals(statusId, trade.statusId) &&
                Objects.equals(tradePlatform, trade.tradePlatform) &&
                Objects.equals(tradeAmountSymbol1, trade.tradeAmountSymbol1) &&
                Objects.equals(tradeAmountSymbol2, trade.tradeAmountSymbol2) &&
                Objects.equals(tradePairLimit, trade.tradePairLimit) &&
                Objects.equals(tradeAmountLimit, trade.tradeAmountLimit) &&
                Objects.equals(tradeSymbol, trade.tradeSymbol) &&
                Objects.equals(tradeClientorderlist, trade.tradeClientorderlist) &&
                Objects.equals(tradeTransactime, trade.tradeTransactime) &&
                Objects.equals(tradePrice, trade.tradePrice) &&
                Objects.equals(tradeOrigqty, trade.tradeOrigqty) &&
                Objects.equals(tradeCummulativequoteqty, trade.tradeCummulativequoteqty) &&
                Objects.equals(tradeStatus, trade.tradeStatus) &&
                Objects.equals(tradeTimeinforce, trade.tradeTimeinforce) &&
                Objects.equals(tradeType, trade.tradeType) &&
                Objects.equals(tradeSide, trade.tradeSide) &&
                Objects.equals(tradeCreationDate, trade.tradeCreationDate) &&
                Objects.equals(tradeUpdateDate, trade.tradeUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeOrderlistid, userEmail, statusId, tradePlatform, tradeAmountSymbol1, tradeAmountSymbol2, tradePairLimit, tradeAmountLimit, tradeSymbol, tradeClientorderlist, tradeTransactime, tradePrice, tradeOrigqty, tradeCummulativequoteqty, tradeStatus, tradeTimeinforce, tradeType, tradeSide, tradeCreationDate, tradeUpdateDate);
    }

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL", referencedColumnName = "USER_EMAIL", nullable = false, insertable = false, updatable = false)
    public UserData getUserDataByUserEmail() {
        return userDataByUserEmail;
    }

    public void setUserDataByUserEmail(UserData userDataByUserEmail) {
        this.userDataByUserEmail = userDataByUserEmail;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false, insertable = false, updatable = false)
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }
}
