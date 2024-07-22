package com.wiseasy.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2024/7/22 16:40
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PayPaycloudCheckoutResponse extends OpenApiResponse {

    // The payment address for the current order on the PayCloud checkout. Merchants should redirect user requests to this page to complete the remaining payment process.
    private String pay_url;

}
