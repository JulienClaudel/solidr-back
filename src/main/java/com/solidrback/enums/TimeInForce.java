package com.solidrback.solidrback.enums;

import lombok.Getter;

@Getter
public enum TimeInForce {
    GTC("GTC"), // Time in Force order that is placed by a trader to purchase or sell at a particular price which remains active until it’s cancelled by him
    IOC("IOC"), // An ImmediateOrCancel order (IOC) is an order to buy or sell at the limit price that executes all or part immediately and cancels any unfilled portion of the order.
    FOK("FOK");  // Same with IOC but if entire conditions are not realized, the order is cancelled. In other hand, If conditions are realized with better proposals, order is adapted to them.
    private final String code;

    TimeInForce(String code) {
        this.code = code;
    }

}

