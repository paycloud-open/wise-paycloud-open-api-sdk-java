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
public class WisehubCloudPayCloseResponse extends OpenApiResponse {

    // Gateway message ID
    private String message_id;

    // Transaction Number.
    private String trans_no;

}
