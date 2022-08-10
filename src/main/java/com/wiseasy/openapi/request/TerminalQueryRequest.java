package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.TerminalQueryResponse;
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
public class TerminalQueryRequest extends OpenApiRequest<TerminalQueryResponse> {

    // Institution no.
    private String institution_no;

    // Merchant NO.
    private String merchant_no;

    // Current page number
    private Integer page_num;

    // Maximum number of paging queries
    private Integer page_size;

}
