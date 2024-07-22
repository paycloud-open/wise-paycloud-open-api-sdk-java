package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayMerchantCheckoutResponse;
import com.wiseasy.openapi.response.PayPaycloudCheckoutResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2024/7/22 16:40
 * @Description: For merchants using the merchant-hosted checkout for payment, submit the order information and card details to AddPay. PayCloud will process the payment immediately and return the payment result synchronously.
 * If 3DS authentication is required, the redirect_url_3dsecure will be returned. Please redirect the user’s request to this URL. After completing the authentication, PayCloud will redirect to the merchant’s return_url. Please handle asynchronous notifications and actively query the order to obtain the payment result.
 */
@Getter
@Setter
@ToString
public class PayMerchantCheckoutRequest extends OpenApiRequest<PayMerchantCheckoutResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Order Amount
    private Double order_amount;

    // Description of the goods or services of the order
    private String description;

    // Order payment timeout period, after which the order can no longer be paid or cancelled and the order will be closed, the unit of this time is: second
    private Integer expires;

    //Bank card payment details. Please encrypt the card_info using PayCloud's public key "gateway_rsa_public_key". Convert the card to a string first, then encrypt the entire string.
    private String card;

    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // For additional information of merchants, the system only does transparent transmission, does not do business processing,
    // payment inquiries and notifications, and the statement download will be returned as it is
    private String attach;

    // Redirect the URL of the user’s page
    private String return_url;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

    // Terminal IP Address
    private String term_ip;

}
