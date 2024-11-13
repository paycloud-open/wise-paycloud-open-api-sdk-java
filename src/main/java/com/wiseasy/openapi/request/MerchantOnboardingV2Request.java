package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.MerchantOnboardingV2Response;
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
public class MerchantOnboardingV2Request extends OpenApiRequest<MerchantOnboardingV2Response> {

    // Institution no.
    private String institution_no;

    // Third-party merchant number
    private String out_merchant_no;

    // Merchant shortname
    private String merchant_name;

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

    // City
    private String city;

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

    private Boolean create_super_admin;

    // Store List
    private String store_list;

    // Settlement
    private String settlement;

    // Whether to open VAT
    private Boolean open_vat;

    // Acquiring Contract List
    private String acquiring_contract_list;

    // Payment App List
    private String payment_app_list;

    // Merchant status,
    // 1: normal, approved merchants, default is 1
    // 2: Frozen, pending review or risky merchants are not allowed to use the service
    private Integer status;

    // Merchant Settlement Electronic Account Status
    // 1 - Normal status
    // 2 - Frozen status, settlement will be suspended
    private Integer e_account_status;

}
