package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayPaycloudCheckoutResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2024/7/22 16:40
 * @Description: The merchant wants to use PayCloud's hosted checkout for payment, redirecting users to PayCloud's checkout page. To achieve this functionality,
 * the merchant can request this API. It will collect the user's order information, save the order within the PayCloud system, and synchronously return the checkout page URL "pay_url".
 * The merchant can then redirect users to this page, where users will input their payment details and complete the payment.
 */
@Getter
@Setter
@ToString
public class PayPaycloudCheckoutRequest extends OpenApiRequest<PayPaycloudCheckoutResponse> {

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

    // Address location of the device: longitude
    private String longitude;

    // Address location of the device: latitude
    private String latitude;

    // To specify certain payment options, the AddPay checkout will only display the corresponding payment methods to the user. If this parameter is not set, all payment options
    // already enabled by the merchant will be displayed. Please refer to the PayOption for the enumeration values of payment options. Multiple values should be separated by commas.
    private String pay_options;

}
