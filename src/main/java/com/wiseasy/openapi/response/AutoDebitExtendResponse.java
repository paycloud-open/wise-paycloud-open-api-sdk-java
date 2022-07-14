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
public class AutoDebitExtendResponse extends OpenApiResponse {

    // Agreement ID of wechat or Alipay+
    private String contract_id;

    // The expiration date of the agreement
    private String contract_expiry_time;

    // Contract extension token
    private String extend_token;

    // Contract Extension Token expiration time
    private String extend_token_expiry_time;

}
