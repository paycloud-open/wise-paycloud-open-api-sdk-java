package com.wiseasy.openapi.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.wiseasy.openapi.response.FileUploadResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.http.entity.mime.content.FileBody;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: This API allows inquiry of all payment orders made from payment gateway. After receiving a status code using this API, merchants can proceed with the next step in service logic
 */
@Getter
@Setter
@ToString
public class FileUploadRequest extends OpenApiRequest<FileUploadResponse>{

    private String institution_no;

    @JSONField(serialize = false)
    private FileBody file_body;

}