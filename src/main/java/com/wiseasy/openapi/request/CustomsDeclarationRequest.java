package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.CustomsDeclarationResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/11/24 16:40
 * @Description: This API is used by merchants to submit additional order information required by customs
 */
@Getter
@Setter
@ToString
public class CustomsDeclarationRequest extends OpenApiRequest<CustomsDeclarationResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant Payment Order Number
    private String merchant_order_no;

    // Merchant system declaration request ID
    private String customs_declaration_request_id;

    // 	1: Customs Declaration 2：Repush Customs Declaration 3：Modify Customs Declaration Info
    private Integer customs_declaration_request_type;

    // Customs
    private String customs;

    // Merchant’s customs registration No.
    private String merchant_customs_no;

    // Customs record name of merchant
    private String merchant_customs_name;

    // Currency type
    private String currency;

    // Customs declaration amount
    private Double customs_declaration_amount;

    // Is split
    private Boolean is_split;

    /**
     * The following parameters are optional input
     */
    // Merchant system order number
    private String sub_merchant_order_no;

    // Merchant system order amount
    private Double sub_order_amount;

    // Logistics cost of opening orders in merchant system
    private Double sub_transport_amount;

    // Amount of goods ordered by merchant system
    private Double sub_product_amount;

    // ID type
    private String certificate_type;

    // ID No.
    private String certificate_id;

    // Name on ID card
    private String certificate_name;

}
