package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.TerminalDetailQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Query terminal details
 */
@Getter
@Setter
@ToString
public class TerminalDetailQueryRequest extends OpenApiRequest<TerminalDetailQueryResponse> {

    // Terminal sn
    private String terminal_sn;

}
