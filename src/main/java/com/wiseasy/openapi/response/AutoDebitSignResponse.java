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
public class AutoDebitSignResponse extends OpenApiResponse {

    // Sign jump URL
    private String sign_url;

    // Delegate to withhold the signing session ID
    private String session_id;

}
