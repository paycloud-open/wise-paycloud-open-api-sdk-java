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
public class WisehubCloudPayOrderResponse extends OpenApiResponse {

    // Gateway message ID
    private String message_id;

    // Transaction Number.
    private String trans_no;

    // Terminal online status
    private String terminal_online_status;

}
