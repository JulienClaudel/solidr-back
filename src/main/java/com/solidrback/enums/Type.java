package com.solidrback.enums;

import lombok.Getter;

@Getter
public enum Type {

    LIMIT("LIMIT");
    private String code;

    Type(String code) {
        this.code = code;
    }
}
