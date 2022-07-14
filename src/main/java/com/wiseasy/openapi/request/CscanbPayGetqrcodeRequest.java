package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.CscanbPayGetqrcodeResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: The merchant's back end invokes this API to create a pre-paid transaction at the back end of the gateway payment service.
 * The gateway returns a link to the picture of the QR code, and the customer scans the QR code with the mobile wallet to start the payment process.
 */
@Getter
@Setter
@ToString
public class CscanbPayGetqrcodeRequest extends OpenApiRequest<CscanbPayGetqrcodeResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Payment Method ID
    private String pay_method_id;

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

    // Order payment timeout period, after which the order can no longer be paid or cancelled and the order will be closed, the unit of this time is: second
    private Integer expires;

    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // For additional information of merchants, the system only does transparent transmission, does not do business processing,
    // payment inquiries and notifications, and the statement download will be returned as it is
    private String attach;

    // The serial numbers of POS and other devices, need to be bound on the merchant platform in advance
    private String terminal_sn;

    // Terminal IP address of payment devices such as POS
    private String term_ip;

    // Address location of the device: longitude
    private String longitude;

    // Address location of the device: latitude
    private String latitude;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

}
