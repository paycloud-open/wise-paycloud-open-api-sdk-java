package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayPreauthCancelResponse;
import lombok.Data;

@Data
public class PayPreauthCancelRequest extends  OpenApiRequest<PayPreauthCancelResponse> {

    private String merchant_no;

    private String orig_merchant_order_no;

    private String orig_trans_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;



}
