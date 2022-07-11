package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.CustomsDeclarationQueryResponse;
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
public class CustomsDeclarationQueryRequest extends OpenApiRequest<CustomsDeclarationQueryResponse>{

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant Payment Order Number
    private String merchant_order_no;

    // Merchant system declaration request ID
    private String customs_declaration_request_id;

    // Customs
    private String customs;

}
