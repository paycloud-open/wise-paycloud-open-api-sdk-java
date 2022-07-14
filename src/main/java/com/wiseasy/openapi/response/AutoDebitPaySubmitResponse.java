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
public class AutoDebitPaySubmitResponse extends OpenApiResponse {

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // Transaction status, 9-Order created;  0-Paying or refunding; 1-Transaction closed; 2-Transaction successful; 3-Transaction cancelled;
    private Integer trans_status;

    /**
     * When trans_status = 2, the following parameters are also returned, and pay_channel_trans_no, customer_paid_amount, and trans_end_time are not empty
     */

    // The serial number of the payment channel, such as WeChat, Alipay, Visa, MasterCard and other payment platforms
    private String pay_channel_trans_no;

    // Buyer user ID, the ID of the user registered by the payer in the wallet application
    private String pay_user_account_id;

    // Transaction amount
    private Double trans_amount;

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

    // VAT: abbreviation, value-added Tax. The payment channel shall collect value-added Tax from merchants according to local government laws
    private Double vat_amount;

    // CNY Amount
    private Double trans_amount_cny;

    // Exchange Rate
    private String exchange_rate;


}
