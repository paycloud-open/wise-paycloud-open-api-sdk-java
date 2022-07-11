package com.wiseasy.openapi.response;

import com.wiseasy.openapi.utils.Constants;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Response object base class
 */
@Getter
@Setter
public class OpenApiResponse{

    /**
     * Status code, 0 means the request is successful, others means failure
     */
    private String code;

    /**
     * Error message
     */
    private String msg;

    /**
     * Interface serial number, used for error search and request record
     */
    private String psn;

    /**
     * signature
     */
    private String sign;

    /**
     * Determine whether the interface request is successful
     * @return
     */
    public boolean isSuccess(){
        return Constants.CODE_SUCCESS.equals(code);
    }


}
