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
public class CustomsDeclarationResponse extends OpenApiResponse {

    // Declare the result status code
    //PROCESSING
    //UNDECLARED
    //SUBMITTED
    //SUCCESS
    //FAIL
    //EXCEPT
    private String state;

    // The channel originally returns a message, and the wechat Alipay interface returns a message
    private String channel_original_message;

}
