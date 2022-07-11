package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.MerchantOnboardingResponse;
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
public class MerchantOnboardingRequest extends OpenApiRequest<MerchantOnboardingResponse>{

    // Institution no.
    private String institution_no;

    // Third-party merchant number
    private String out_merchant_no;

    // Merchant shortname
    private String merchant_name;

    /**
     * The following parameters are optional input
     */

    // Merchant full name
    private String merchant_full_name;

    // Merchant Type
    private String merchant_type;

    // Incorporation Certificate Number
    private String registration_certificate_number;

    // Certificate Expiry Date
    private String registration_certificate_date;

    // Principal Name
    private String principal_name;

    // Principal ID Number
    private String principal_id_number;

    // Principal ID Expiry
    private String principal_certificate_date;

    // Merchant Category
    private String mcc;

    // Country
    private String country;

    // Address
    private String address_detail;

    // Sales Email Address
    private String sales_employee_email;

    // Business Type
    private String business_type;

    // Contact Name
    private String contact_name;

    // Contact Email
    private String contact_email;

    // Contact Phone
    private String contact_phone;

    // Third-party store number
    private String out_store_no;

    // Store Name
    private String store_name;

    // Store Address
    private String store_address_detail;

    // Pos SN
    private String terminal_sn;

    // DEBIT Card Rate(%)
    private String debit_rate;

    // CREDIT Card Rate(%)
    private String credit_rate;

    // Open VAT
    private Boolean open_vat;

    // Whether Open Settlement
    private Boolean open_settle;

    // Settlement Cycle
    private String settlement_cycle;

    // Account Number
    private String account_no;

    // Settlement Account Holder
    private String account_holder;

    // Account Branch
    private String account_branch;

    // Bank Acquirer Merchant Number
    private String mid;

    // Bank Acquiring Terminal Number
    private String tid;

}
