package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.WisehubCloudPayOrderResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: he back end of the merchant invokes this API to create a pre-paid transaction on the back end of the gateway payment service.
 * The gateway pushes a message to the designated application of the iot device (such as smart POS), arouses the cashier application on the device
 * to display the order, the cashier confirms the order, and guides the user to complete the payment.
 */
@Getter
@Setter
@ToString
public class WisehubCloudPayOrderRequest extends OpenApiRequest<WisehubCloudPayOrderResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // The serial numbers of POS and other devices, need to be bound on the merchant platform in advance
    private String terminal_sn;

    // Payment method category
    private String pay_method_category;

    // Payment Method ID
    private String pay_method_id;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Order amount
    private Double order_amount;

    // Transaction type
    private Integer trans_type;

    // Description of the goods or services of the order
    private String description;

    /**
     * The following parameters are optional input
     */

    // Original merchant system order number
    private String orig_merchant_order_no;

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // For additional information of merchants, the system only does transparent transmission, does not do business processing,
    // payment inquiries and notifications, and the statement download will be returned as it is
    private String attach;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

    // Message receiving application
    // WISEHUB(default)
    // WISECASHIER
    private String message_receiving_application;
}
