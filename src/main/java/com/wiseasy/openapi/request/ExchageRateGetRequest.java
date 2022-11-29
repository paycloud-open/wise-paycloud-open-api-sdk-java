package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.ExchageRateGetResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2022/11/19 16:40
 * @Description: When the goods on the merchant website are priced in foreign currencies, the conversion exchange rate used by the
 * payment provider can be queried in real time through this interface Now, only WeChat payment exchange rate query is paid. The
 * exchange rate is updated at 10:00 a.m. Beijing time, once a day.
 */
@Getter
@Setter
@ToString
public class ExchageRateGetRequest extends OpenApiRequest<ExchageRateGetResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Pay Method Id
    private String pay_method_id;

    // Local Currency
    private String local_currency;

    // Foreign currency
    private String foreign_currency;

    // Date
    private String date;
}
