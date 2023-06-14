package com.wiseasy.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 */
@Getter
@Setter
@ToString(callSuper = true)
public class OrderQueryResponse extends OpenApiResponse {

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // Trans Type
    private Integer trans_type;

    // Transaction status, 9-Order created;  0-Paying or refunding; 1-Transaction closed; 2-Transaction successful; 3-Transaction cancelled;
    private Integer trans_status;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // Order amount
    private Double order_amount;

    // Priced transaction amount
    private Double trans_amount;

    // Customer pays handling fee
    private Double trans_fee_c;

    // For additional information of merchants, the system only does transparent transmission, does not do business processing,
    // payment inquiries and notifications, and the statement download will be returned as it is
    private String attach;

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // The serial numbers of POS and other devices, need to be bound on the merchant platform in advance
    private String terminal_sn;

    // Payment Scenario
    private String pay_scenario;

    /**
     * When trans_status = 2, the following parameters are also returned, and pay_channel_trans_no, customer_paid_amount, and trans_end_time are not empty
     */

    // The serial number of the payment channel, such as WeChat, Alipay, Visa, MasterCard and other payment platforms
    private String pay_channel_trans_no;

    // Buyer user ID, the ID of the user registered by the payer in the wallet application
    private String pay_user_account_id;

    // The actual amount of cash paid by the customer
    private Double paid_amount;

    // Merchants give customers preferential amounts through payment channels, and this part of the payment channels will not be settled to merchants
    private Double discount_bmopc;

    // The amount of the payment channel discount to the customer, this part of the funds will be settled to the merchant account
    private Double discount_bpc;

    // When the transaction is completed
    // Greenwich mean time, time zone: UTC / GMT 0 (zero time zone)
    // Format: YYYY-MM-DD HH:mm:ss
    // For example: 2021-06-03 12:48:51
    private String trans_end_time;

    // Pay Method Id
    private String pay_method_id;

    // VAT: abbreviation, value-added Tax. The payment channel shall collect value-added Tax from merchants according to local government laws
    private Double vat_amount;

    // CNY Amount
    private Double trans_amount_cny;

    // Exchange Rate
    private String exchange_rate;

    // Transaction reference number
    private String ref_no;

    // Payment platform serial number
    private String pay_platform_trans_no;

}
