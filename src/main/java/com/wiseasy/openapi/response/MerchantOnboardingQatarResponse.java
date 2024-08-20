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
public class MerchantOnboardingQatarResponse extends OpenApiResponse {

    // Merchant NO.
    private String merchant_no;

    // Store NO.
    private String store_no;

}
