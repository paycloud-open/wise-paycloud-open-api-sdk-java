package com.wiseasy.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExchageRateGetResponse extends OpenApiResponse {

    // Exchange rate time
    private String rate_time;

    // Spot exchange selling price (exchange rate)
    private String rate;
}
