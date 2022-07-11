package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.AutoDebitSignQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Merchants call this interface to query signing information
 */
@Getter
@Setter
@ToString
public class AutoDebitSignQueryRequest extends OpenApiRequest<AutoDebitSignQueryResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Payment Method ID
    private String pay_method_id;

    // Merchant side agreement number
    private String out_contract_code;


    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // ID of subpayment method
    private String sub_pay_method_id;

    // ID of merchant sub-application
    private String sub_appid;

}
