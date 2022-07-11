package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.MerchantOnboardingResponse;
import com.wiseasy.openapi.response.MerchantQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: To use the payment gateway’s ability to pay, you need to register your merchant information. Through this API, the institution can register the merchant’s KYC online and obtain the merchant’s ID.
 */
@Getter
@Setter
@ToString
public class MerchantQueryRequest extends OpenApiRequest<MerchantQueryResponse>{

    // Institution no.
    private String institution_no;

    /**
     * The following parameters are optional input
     */

    // Third-party merchant number
    private String out_merchant_no;

    // Merchant NO.
    private String merchant_no;

}
