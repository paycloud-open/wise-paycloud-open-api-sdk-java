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
public class AlipayplusBrandQueryResponse extends OpenApiResponse {

    // Enabled
    private Boolean enabled;

    // Brand Name
    private String brandName;

    // PromoNames
    private String promoNames;

    // Logos
    private String logos;

}
