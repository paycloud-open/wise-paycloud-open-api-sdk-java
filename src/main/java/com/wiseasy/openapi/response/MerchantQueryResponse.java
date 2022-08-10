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
public class MerchantQueryResponse extends OpenApiResponse {

    // Institution no.
    private String institution_no;

    // Merchant NO.
    private String merchant_no;

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

    // Open VAT
    private Boolean open_vat;

    // Whether Open Settlement
    private Boolean open_settle;

    // Account Number
    private String account_no;

    // Settlement Account Holder
    private String account_holder;

    // Account Branch
    private String account_branch;

    // Terminal registration time, time zone: UTC / GMT 0, Format: YYYY-MM-DD HH:mm:ss
    private String add_time;

    // Merchant status,
    // 1: normal, approved merchants, default is 1
    // 2: Frozen, pending review or risky merchants are not allowed to use the service
    private Integer status;

}
