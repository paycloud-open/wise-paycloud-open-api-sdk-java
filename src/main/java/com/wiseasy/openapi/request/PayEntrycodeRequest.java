package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayEntrycodeResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: With Merchant-presented Mode Payment, a user can scan the QR code presented by the merchant to complete the payment.
 * In this mode, the QR code is a static QR code, which is also called an entry code.This mode is generally used offline. Merchants have physical stores.
 * Merchants can make qr codes into materials, show them to customers, and use wallets to scan the code for payment
 */
@Getter
@Setter
@ToString
public class PayEntrycodeRequest extends OpenApiRequest<PayEntrycodeResponse> {

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

    // Priced transaction amount
    private Double trans_amount;

    // Description of the goods or services of the order
    private String description;

    // User browser header userAgent
    private String browser_head_user_agent;

    // Order payment timeout period, after which the order can no longer be paid or cancelled and the order will be closed, the unit of this time is: second
    private Integer expires;

    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // Payment Method ID
    private String pay_method_id;

    // If pay_method_id = Alipay+, this parameter is required
    private String sub_pay_method_id;

    // For additional information of merchants, the system only does transparent transmission, does not do business processing,
    // payment inquiries and notifications, and the statement download will be returned as it is
    private String attach;

    // Redirect the URL of the user’s page
    private String return_url;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

    // Type of mobile operating system
    private String os_type;

    // Terminal IP Address
    private String term_ip;

    // The language that the Checkout page displays
    private String language;

    // Wechat Pay product type
    private String wechatpay_product_type;

    // Wechat sub-merchant public account ID
    private String sub_appid;

    // Wechat user sub-id
    private String sub_openid;

    // extended parameter
    private String ext_params;

}
