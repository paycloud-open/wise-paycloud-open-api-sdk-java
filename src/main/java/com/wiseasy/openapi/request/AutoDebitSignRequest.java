package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.AutoDebitSignResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Merchants can invoke this interface to obtain the resources needed to activate the entrusting agent signing page.
 * Merchants can activate the entrusting agent signing page through H5 web page, PC web page, small program, APP and other ways. At present,
 * only wechat Pay and Alipay+’s entrusted withholding business is supported.
 */
@Getter
@Setter
@ToString
public class AutoDebitSignRequest extends OpenApiRequest<AutoDebitSignResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Payment Method ID
    private String pay_method_id;

    // Merchant side agreement number
    private String out_contract_code;

    // Type of terminal applicable to merchant services
    private String terminal_type;

    // Order payment timeout period, after which the order can no longer be paid or cancelled and the order will be closed, the unit of this time is: second
    private Integer expires;

    // User CLIENT IP address
    private String user_client_ip;


    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;

    // The user ID
    private String sub_openid;

    // ID of merchant sub-application
    private String sub_appid;

    // User account display name
    private String user_display_name;

    // User browser userAgent
    private String browser_head_user_agent;

    // Mobile operating system type
    private String os_type;

    // Specifies the callback address for receiving gateway payment notifications
    private String notify_url;

    // Sign up to complete the front-end jump URL
    private String return_url;

    // ID of subpayment method
    private String sub_pay_method_id;

}
