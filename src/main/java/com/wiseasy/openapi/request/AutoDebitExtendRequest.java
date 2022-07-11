package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.AutoDebitExtendResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: The entrustment withholding agreement signed by Alipay+ users and merchants has a validity period. After the validity
 * period expires, merchants can first terminate the agreement and then re-sign it, or renew it. Wechat Pay’s withholding agreement is
 * for life and does not need to be renewed.
 */
@Getter
@Setter
@ToString
public class AutoDebitExtendRequest extends OpenApiRequest<AutoDebitExtendResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Payment Method ID
    private String pay_method_id;

    // Contract extension token
    private String extend_token;


    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // ID of subpayment method
    private String sub_pay_method_id;

}
