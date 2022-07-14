package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.OrderQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: This API allows inquiry of all payment orders made from payment gateway. After receiving a status code using this API, merchants can proceed with the next step in service logic
 */
@Getter
@Setter
@ToString
public class OrderQueryRequest extends OpenApiRequest<OrderQueryResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Transaction Srial Number
    private String trans_no;

}
