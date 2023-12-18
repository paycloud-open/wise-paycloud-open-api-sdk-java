package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.ReconcileTransSummarizeResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author wangyuxiang
 * @since 2023-12-14 09:27
 */
@Getter
@Setter
@ToString
public class ReconcileTransSummarizeRequest extends OpenApiRequest<ReconcileTransSummarizeResponse>{


    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // The serial numbers of POS and other devices, need to be bound on the merchant platform in advance
    private String terminal_sn;

    // Price currency-ISO three-digit letter code,For example: CNY,USD
    private String price_currency;

    // The start time of the query, time zone: UTC/GMT 0, format: YYYY-MM-DD HH: mm: ss Example: 2023-11-22 22:00:00
    private String time_start;

    // The end time of the query, time zone: UTC/GMT 0, format: YYYY-MM-DD HH: mm: ss Example: 2023-11-23 21:59:59
    private String time_end;

    // Payment Method ID
    private String pay_method_id;

}
