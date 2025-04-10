package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayTokenResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2025/4/10 16:40
 * @Description: After a card-not-present (CNP) payment is completed through checkout (excluding other payment products such as QR payments), a security token will be generated for recurring payments and subscription payments. This API can query the payment token from previously successful transactions.
 *
 * Please securely store the token. A token can only be obtained once per transaction and can only be used for one subsequent payment.
 */
@Getter
@Setter
@ToString
public class PayTokenQueryRequest extends OpenApiRequest<PayTokenResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Transaction Srial Number
    private String trans_no;

}
