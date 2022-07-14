package com.wiseasy.openapi.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 */
@Getter
@Setter
@ToString(callSuper = true)
public class CustomsDeclarationQueryResponse extends OpenApiResponse {

    // Declaration records, split order may contain more than one record
    private List<DeclarationRecord> declaration_records;

    // The channel originally returns a message, and the wechat Alipay interface returns a message
    private String channel_original_message;

    @Data
    public static class DeclarationRecord {

        // Declare the result status code
        //PROCESSING
        //UNDECLARED
        //SUBMITTED
        //SUCCESS
        //FAIL
        //EXCEPT
        private String state;

        // Customs
        private String customs;

        // Merchant’s customs registration No.
        private String merchant_customs_no;

        // Merchant system order number
        private String sub_merchant_order_no;

        // Merchant system order amount
        private BigDecimal sub_order_amount;

        // Logistics cost of opening orders in merchant system
        private BigDecimal sub_transport_amount;

        // Amount of goods ordered by merchant system
        private BigDecimal sub_product_amount;

        // Declaration result Description
        private String explanation;

        // Return time of declaration result
        private String customs_result_returned_time;

    }

}
