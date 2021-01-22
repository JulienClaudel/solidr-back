package com.solidrback.model;

import com.solidrback.enums.Side;
import com.solidrback.enums.Symbol;
import com.solidrback.enums.TimeInForce;
import com.solidrback.enums.Type;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Builder
@Data
@Slf4j
public class TradeMarketDTO {

    public static TradeMarketDTO fromArray(List<Object> trade, Symbol symbol, Side side, Type type, TimeInForce timeInForce){
        int i = 0;
        TradeMarketDTO ci = TradeMarketDTO.builder()
                .symbol(symbol)
                .side(side)
                .type(type)
                .timeInForce(timeInForce)
                .tradeClientorderlist(trade.get(i++).toString())
                .tradePrice(trade.get(i++).toString())
                .tradeOrigqty(trade.get(i++).toString())
                .build();

        return ci;
    }


    private Symbol symbol;
    private Side side;
    private Type type;
    private TimeInForce timeInForce;
    private String tradeClientorderlist;
    private String tradePrice;
    private String tradeOrigqty;


    public TradeMarketDTO() {
    }

    public TradeMarketDTO(Symbol symbol, Side side, Type type, TimeInForce timeInForce, String tradeClientorderlist, String tradePrice, String tradeOrigqty) {
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.timeInForce = timeInForce;
        this.tradeClientorderlist = tradeClientorderlist;
        this.tradePrice = tradePrice;
        this.tradeOrigqty = tradeOrigqty;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getTradeClientorderlist() {
        return tradeClientorderlist;
    }

    public void setTradeClientorderlist(String tradeClientorderlist) {
        this.tradeClientorderlist = tradeClientorderlist;
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

    public String simpleToString(){
        return String.format("tradeClientorderlist: %s tradePrice: %s tradeOrigqty: %s "
                , tradeClientorderlist
                , tradePrice
                , tradeOrigqty);
    }

}
