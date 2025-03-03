package com.wiseasy.openapi.utils;

public enum EAuthType {
    BASIC_AUTH("BASIC_AUTH"),
    RSA2("RSA2");

    private String value;

    EAuthType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
