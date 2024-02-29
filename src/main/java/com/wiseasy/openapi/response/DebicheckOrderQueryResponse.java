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
public class DebicheckOrderQueryResponse extends OpenApiResponse {

    // Transaction Number.
    private String serial_no;

    // Specifies merchant NO assigned by payment gateway
    private String merchant_no;

    // You can get the terminal sn from the merchant platform if you have already added the terminal
    private String terminal_sn;

    // 0- In progress;
    // 1- Failure;
    // 2- Successful
    // 3- Canceled
    private Integer check_status;

    // Contract reference number
    private String contract_reference_number;

    // Creditor name
    private String creditor_name;

    // Debtor identification number
    private String debtor_identification_number;

    // Maximum amount
    private Double maximum_amount;

    // Installment amount
    private Double installment_amount;

    // Bank card number to be verified
    private String account_no;

    // Debicheck authentication request time, time zone: UTC/GMT 0, Format: YYYY-MM-DD HH:mm:ss
    private String date;

    // Bank MID
    private String mid;

    // Bank TID
    private String tid;

    // Card_brand
    private String card_brand;

    // 0: Unknown; 1: Debit card; 2: Credit card
    private String card_type;

    // Verification failure error code, returned when check_status=1
    private String debicheck_error_code;

    // Reason for verification failure, return this parameter when check_status=1
    private String debicheck_error_msg;

}
