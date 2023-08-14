package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.TerminalDeleteResponse;
import com.wiseasy.openapi.response.TerminalQueryResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2023/8/14 16:40
 * @Description: Delete a merchant's device
 */
@Getter
@Setter
@ToString
public class TerminalDeleteRequest extends OpenApiRequest<TerminalDeleteResponse> {

    // Institution no.
    private String institution_no;

    // Merchant NO.
    private String merchant_no;

    // Terminal sn
    private String terminal_sn;

}
