package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.OrderRefundSubmitResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: For a period after a payment transaction has been completed and a refund is required by either the Payer or Merchant, the Merchant can refund the Payer via this API. After the gateway payment system receives and verifies the refund request successfully, the payer will be refunded with the request refund amount (less than or equal to the original payment amount) according to the refund rules.
 */
@Getter
@Setter
@ToString
public class OrderRefundSubmitRequest extends OpenApiRequest<OrderRefundSubmitResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Order Number Of The Original Merchant System
    private String orig_merchant_order_no;

    // The Original Transaction NO.
    private String orig_trans_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Order Amount
    private Double order_amount;

    // Refund Amount
    private Double trans_amount;

    // Refund Reason
    private String description;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

    // extended parameter
    private String ext_params;
}
