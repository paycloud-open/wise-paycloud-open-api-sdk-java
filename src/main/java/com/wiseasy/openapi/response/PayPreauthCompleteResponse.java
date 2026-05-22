package com.wiseasy.openapi.response;

import lombok.Data;

@Data
public class PayPreauthCompleteResponse  extends OpenApiResponse {

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // Amount of the transaction
    private Double trans_amount;

    // Customer pays handling fee
    private Double trans_fee_c;

    // VAT
    private Double vat_amount;

}
