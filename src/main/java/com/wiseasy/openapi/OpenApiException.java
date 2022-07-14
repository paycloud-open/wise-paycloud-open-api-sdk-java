/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wiseasy.openapi;


/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Custom exception object
 */
public class OpenApiException extends Exception {

    private String errCode;
    private String errMsg;

    public OpenApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}