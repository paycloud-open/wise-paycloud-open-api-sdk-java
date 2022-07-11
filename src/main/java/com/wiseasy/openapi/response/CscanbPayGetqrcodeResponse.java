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
public class CscanbPayGetqrcodeResponse extends OpenApiResponse{

    // The transaction serial number returned by the gateway, which uniquely identifies a transaction
    private String trans_no;

    // This parameter is used to create a QR code that will be displayed to the customer for payment
    private String qrcode_url;

    // Original request message of the payment company
    private String pay_original_request;

    // Original response message requesting payment company
    private String pay_original_response;

}
