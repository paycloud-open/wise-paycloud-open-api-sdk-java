package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.OrderRefundQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: After submitting Submit Refund, you can call this API to check the status of the Refund. After the refund is submitted, there may be a delay in the refund processing. The specific refund arrival time is subject to the actual refund time of the payment channel
 */
@Getter
@Setter
@ToString
public class OrderRefundQueryRequest extends OpenApiRequest<OrderRefundQueryResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Transaction Srial Number
    private String trans_no;

}
