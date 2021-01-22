package com.solidrback.enums;

import lombok.Getter;

@Getter
public enum Side {

    BUY("BUY"),
    SELL("SELL");
    private String code;

    Side(String code) {
        this.code = code;
    }
}
