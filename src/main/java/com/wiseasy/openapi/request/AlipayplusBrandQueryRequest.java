package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.AlipayplusBrandQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: This interface can be invoked to terminate the contract when the contract relationship between the merchant and the user is wrong or the merchant initiatively requests to terminate the previous contract with the user
 */
@Getter
@Setter
@ToString
public class AlipayplusBrandQueryRequest extends OpenApiRequest<AlipayplusBrandQueryResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // LogoPattern
    private String logoPattern;

    /**
     * The following parameters are optional input
     */

    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;
}
