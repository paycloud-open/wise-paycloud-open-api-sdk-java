package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.WisehubCloudMessageSendResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: A merchant’s back end invokes this API, and the gateway can send messages to a specific application (WiseHub) installed by a specified smart device (such as smart POS), supporting voice messages and receipt printing template messages.
 */
@Getter
@Setter
@ToString
public class WisehubCloudMessageSendRequest extends OpenApiRequest<WisehubCloudMessageSendResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // Merchant message request ID
    private String merchant_request_id;

    // Terminal Device Serial Number
    private String terminal_sn;

    // Language used for broadcasting and printing Example: zh-CN, EN-US, JA-JP, etc
    private String language;

    /**
     * The following parameters are optional input
     */

    // Voice Notification Content
    private String voice_content;

    // Print the contents of the receipt
    private String receipt_content;
}
