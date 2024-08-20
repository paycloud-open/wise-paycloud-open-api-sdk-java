package com.wiseasy.openapi.utils;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: Constant definition
 */
public class Constants {

    // app_id
    public static final String APP_ID = "app_id";

    // Interface request method
    public static final String METHOD = "method";

    // Request data format
    public static final String FORMAT = "format";

    // Encoding format requested
    public static final String CHARSET = "charset";

    // The type of signature algorithm used by the merchant to generate the signature string, currently supports RSA
    public static final String SIGN_TYPE = "sign_type";

    // Sign
    public static final String SIGN = "sign";

    // The time to send the request cannot exceed 15 minutes before and after the standard time
    public static final String TIMESTAMP = "timestamp";

    // Request data format: JSON
    public static final String FORMAT_JSON = "JSON";

    // Encoding format: UTF-8
    public static final String CHARSET_UTF8 = "UTF-8";

    // Algorithm type: RSA
    public static final String SIGN_TYPE_RSA2 = "RSA2";

    // Version
    public static final String VERSION = "version";

    // Version value
    public static final String VERSION_VALUE = "1.0";

    // Status code, 0 means the request is successful, others means failure
    public static final String CODE = "code";

    // Error message
    public static final String MSG = "msg";

    // Return data
    public static final String DATA = "data";

    // The unique ID that is assigned by a merchant to identify a http request. Special characters are not supported
    public static final String HTTP_REQUEST_ID = "http_request_id";

    public static final String HTTP_REQUEST_HEADER_PSN = "Http-Request-Psn";

    // Status code, 0: success
    public static final String CODE_SUCCESS = "0";

    // Error code definition
    public static final String PARAMETER_IS_EMPTY = "CLI001";

    public static final String SIGNATURE_FAILURE = "CLI002";

    public static final String REQUEST_SERVER_FAILED = "CLI003";

    public static final String VERIFY_SIGNATURE_FAILED = "CLI004";

    public static final String API_ENTRY_URL = "api/entry";
    public static final String API_FILE_UPLOAD_URL = "api/file/upload";

}
