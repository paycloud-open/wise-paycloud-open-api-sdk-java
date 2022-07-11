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
public class AutoDebitSignQueryResponse extends OpenApiResponse{
    // Merchant side agreement number
    private String out_contract_code;

    // Agreement ID of wechat or Alipay+
    private String contract_id;

    // Agreement state
    private String state;

    // Agreement Signing Time
    private String signed_time;

    // Termination time of the agreement
    private String terminated_time;

    // The user id
    private String customer_id;

    // The expiration date of the agreement
    private String contract_expiry_time;

    // Contract extension token
    private String extend_token;

    // Contract Extension Token expiration time
    private String extend_token_expiry_time;

    // Agreement termination method
    private String contract_termination_mode;

}
