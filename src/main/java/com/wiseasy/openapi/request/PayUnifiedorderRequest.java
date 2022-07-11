package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayUnifiedorderResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: For the web payment scenario, the merchant’s back end calls this API to create a prepaid transaction on the back end
 * of the gateway payment service and initiates the payment process through the web page link. Our web checkout page handles the different
 * logic of various payment methods, making it easier to connect your payments so you can focus on your business rather than your payments
 */
@Getter
@Setter
@ToString
public class PayUnifiedorderRequest extends OpenApiRequest<PayUnifiedorderResponse>{

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Priced transaction amount
    private Double trans_amount;

    // Description of the goods or services of the order
    private String description;

    // Terminal type applicable to Merchant Services
    private String terminal_type;

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

    // User browser header userAgent
    private String browser_head_user_agent;

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
