package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayPreauthCompleteResponse;
import lombok.Data;

@Data
public class PayPreauthCompleteRequest extends OpenApiRequest<PayPreauthCompleteResponse>{

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

    // WeChat Official Account APP ID
    private String sub_appid;
}
