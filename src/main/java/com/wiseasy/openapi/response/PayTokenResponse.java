package com.wiseasy.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PayTokenResponse extends OpenApiResponse {

    // Payment Token
    private String token;

    // Token expiry time, time zone: UTC/GMT 0, format: YYYY-MM-DD HH: mm: ss Example: 2021-06-03 12:48:51
    private String expires_at;




}
