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
public class OrderRefundQueryResponse extends OpenApiResponse {

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // The Original Payment Transaction No.
    private String orig_trans_no;

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


    /**
     * When trans_status = 2, the following parameters are also returned, and pay_channel_trans_no, customer_paid_amount, and trans_end_time are not empty
     */

    // The serial number of the payment channel, such as WeChat, Alipay, Visa, MasterCard and other payment platforms
    private String pay_channel_trans_no;

    // When the transaction is completed
    // Greenwich mean time, time zone: UTC / GMT 0 (zero time zone)
    // Format: YYYY-MM-DD HH:mm:ss
    // For example: 2021-06-03 12:48:51
    private String trans_end_time;

    // CNY Amount
    private Double trans_amount_cny;

    // Exchange Rate
    private String exchange_rate;

    // VAT: abbreviation, value-added Tax. The payment channel shall collect value-added Tax from merchants according to local government laws
    private Double vat_amount;

    // Transaction reference number
    private String ref_no;

    // Payment platform serial number
    private String pay_platform_trans_no;

    // Cashier app or rigister app version
    private String app_version;

    // Transaction error code, this parameter appears when trans_status = 1
    private String trans_error_code;

    // Transaction error message, this parameter appears when trans_status = 1
    private String trans_error_msg;

}
