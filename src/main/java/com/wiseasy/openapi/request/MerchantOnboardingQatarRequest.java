package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.MerchantOnboardingQatarResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: To use the payment gateway’s ability to pay, you need to register your merchant information. Through this API, the institution can register the merchant’s KYC online and obtain the merchant’s ID.
 */
@Getter
@Setter
@ToString
public class MerchantOnboardingQatarRequest extends OpenApiRequest<MerchantOnboardingQatarResponse> {

    // Institution no.
    private String institution_no;

    // Third-party merchant number
    private String out_merchant_no;

    // Merchant shortname
    private String merchant_name;

    // The name on the certificate, usually the business name registered with national tax or commercial administration authorities.
    private String legal_name;

    // Type of Business
    private String business_type;

    // Nature of Business
    private String business_nature;

    // Merchant Category
    private String mcc;

    // The certificate number of the enterprise registered with the management department of the country where it is located
    private String registration_certificate_number;

    // Address
    private String address_detail;

    // Contact Name
    private String contact_name;

    // Contact Email
    private String contact_email;

    // Contact Phone
    private String contact_phone;

    // Merchant contract fee rate plan template ID
    private String mdr_plan_id;

    // Merchant risk control plan template ID
    private String risk_plan_id;

    // Third-party store number
    private String out_store_no;

    // Store Name
    private String store_name;

    // Store Address
    private String store_address_detail;

    // Pos SN
    private String terminal_sn;

    // Type of Opened Channels
    private String cp_channel_type;

    // Bank Acquirer Merchant Number
    private String mid;

    // Merchant MID assigned by QNB(Exclusive to Amex)
    private String amex_mid;

    // Bank Acquiring Terminal Number
    private String tid;

    // Supported transaction types
    private String support_trans_type_list;

}
