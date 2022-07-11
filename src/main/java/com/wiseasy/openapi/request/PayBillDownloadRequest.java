package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.PayBillDownloadResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Merchants and service providers can download historical transaction lists through this interface. For example,
 * the data inconsistency between the merchant system and the payment gateway is caused by order drop or system error, and the
 * payment status can be corrected after checking the bill.
 */
@Getter
@Setter
@ToString
public class PayBillDownloadRequest extends OpenApiRequest<PayBillDownloadResponse>{

    // Transaction date
    // The transaction date in the time zone where the merchant is located, in the format YYYY-MM-DD
    private String trans_date;

}
