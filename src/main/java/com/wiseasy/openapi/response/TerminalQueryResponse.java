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
public class TerminalQueryResponse extends OpenApiResponse {

    // Total number of terminals
    private Integer total;

    // The list of terminals currently returned
    private String list;
}
