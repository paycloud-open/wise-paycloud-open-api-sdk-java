package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.OrderRevokerResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: When a payment transaction isn’t successfully returned or the payment system times out, this API is called to cancel the transaction. After revoking, the successful order will be refunded, while the failed order will be closed
 */
@Getter
@Setter
@ToString
public class OrderRevokerRequest extends OpenApiRequest<OrderRevokerResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

}
