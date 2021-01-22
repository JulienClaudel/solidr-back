package com.solidrback.enums;

import lombok.Getter;

@Getter
public enum Limit {
    CINQCENT("500",500);
    private final String code;
    private Integer limit;

    Limit(String code, Integer limit) {
        this.code = code;
        this.limit = limit;
    }
}
