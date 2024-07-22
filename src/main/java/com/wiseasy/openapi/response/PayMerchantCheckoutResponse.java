package com.wiseasy.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2024/7/22 16:40
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PayMerchantCheckoutResponse extends OpenApiResponse {

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // Transaction status, 9-Order created;  0-Paying or refunding; 1-Transaction closed; 2-Transaction successful; 3-Transaction cancelled;
    private Integer trans_status;

    // The payment address for the current order on the PayCloud checkout. Merchants should redirect user requests to this page to complete the remaining payment process.
    private String redirect_url_3dsecure;

    // The serial number of the payment channel, such as WeChat, Alipay, Visa, MasterCard and other payment platforms
    private String pay_channel_trans_no;

    // Buyer user ID, the ID of the user registered by the payer in the wallet application
    private String pay_user_account_id;

    // When the transaction is completed
    // Greenwich mean time, time zone: UTC / GMT 0 (zero time zone)
    // Format: YYYY-MM-DD HH:mm:ss
    // For example: 2021-06-03 12:48:51
    private String trans_end_time;

    // Pay Method Id
    private String pay_method_id;

    // Transaction reference number
    private String ref_no;

}
