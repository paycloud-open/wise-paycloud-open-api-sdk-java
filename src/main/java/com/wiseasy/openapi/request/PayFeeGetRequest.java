package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayFeeGetResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: When the user pays the service fee, the transaction fee amount and consumption tax amount can be obtained through this interface for the user to confirm the transaction amount.
 */
@Getter
@Setter
@ToString
public class PayFeeGetRequest extends OpenApiRequest<PayFeeGetResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Payment Scenario
    private String pay_scenario;

    // Payment Method ID
    private String pay_method_id;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Order Amount
    private Double order_amount;

    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // ID of subpayment method
    private String sub_pay_method_id;

}
