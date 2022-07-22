package com.wiseasy.openapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.openapi.request.FileUploadRequest;
import com.wiseasy.openapi.request.OpenApiRequest;
import com.wiseasy.openapi.response.FileUploadResponse;
import com.wiseasy.openapi.response.OpenApiResponse;
import com.wiseasy.openapi.sign.SignHandler;
import com.wiseasy.openapi.utils.Constants;
import com.wiseasy.openapi.utils.FileUtil;
import com.wiseasy.openapi.utils.HttpClientUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.mime.content.FileBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: liqie
 * @Date: 2021/6/3 16:40
 * @Description: The client class that accesses the Open Service Gateway
 */
public class OpenApiClient {

    /**
     * The log object
     */
    private Log log = LogFactory.getLog(this.getClass());

    /**
     * Application ID, the unique identification of the developer's application. Before development, you need to contact your technical support staff to register
     */
    private String appId;

    /**
     * To open the service gateway server address, see the definition of the Constants class: Constants.SANDBOX_GATEWAY_URL
     */
    private String gatewayUrl;

    /**
     * The RSA private key of the application will not be uploaded to the gateway server. Please keep it safe. To apply the public key,
     * you need to contact technical support personnel to configure it into your gateway application
     */
    private String appRsaPrivateKey;

    /**
     * Gateway's RSA public key, which is used to verify the packet signature of the gateway request or return to obtain this public key
     */
    private String gatewayRsaPublicKey;

    public OpenApiClient(String appId, String gatewayUrl, String appRsaPrivateKey, String gatewayRsaPublicKey) {
        this.appId = appId;
        this.gatewayUrl = gatewayUrl;
        this.appRsaPrivateKey = appRsaPrivateKey;
        this.gatewayRsaPublicKey = gatewayRsaPublicKey;
    }

    /**
     * Call the internal handler function of the gateway API
     *
     * @param <T>
     * @param request The request object
     * @return Response object
     * @throws OpenApiException
     */
    public <T extends OpenApiResponse> T execute(OpenApiRequest<T> request) throws OpenApiException {
        // Basic parameter check
        if (request == null) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "The parameter [request] cannot be null");
        }
        paramsCheck();

        // Convert the request OpenApiRequest to JSON
        JSONObject requestParams = JSONObject.parseObject(JSON.toJSONString(request));

        // Build common request parameters
        buildCommonParameters(request, requestParams);

        // Build common request header
        Map<String, Object> reqHeaders = new HashMap<>();
        String httpRequestPsn = genHttpRequestId();
        reqHeaders.put(Constants.HTTP_REQUEST_HEADER_PSN, httpRequestPsn);

        // Signature
        requestParams.put(Constants.SIGN, SignHandler.sign(appRsaPrivateKey, requestParams));

        // Request gateway server Rest api
        String apiUrl = gatewayUrl + Constants.API_ENTRY_URL;
        String resultStr;
        try {
            log.info("Request to gateway[" + apiUrl + "] send data [Http-Request-Psn = " + httpRequestPsn + "] -->> " + requestParams.toJSONString());

            resultStr = HttpClientUtil.doPost(apiUrl, reqHeaders, requestParams);

            log.info("Response from gateway[" + apiUrl + "] receive data [Http-Request-Psn = " + httpRequestPsn + "] <<-- " + resultStr);
        } catch (Exception e) {
            log.error("Request to gateway[" + apiUrl + "] fail", e);
            throw new OpenApiException(Constants.REQUEST_SERVER_FAILED, "Request to gateway fail");
        }
        JSONObject resultJson = JSONObject.parseObject(resultStr);

        // Verify signature
        if (!SignHandler.verifySign(gatewayRsaPublicKey, resultJson)) {
            throw new OpenApiException(Constants.VERIFY_SIGNATURE_FAILED, "Response data signature error");
        }

        // Convert the returned JSON to OpenApiResponse
        Object data = resultJson.get(Constants.DATA);
        if (data != null) {
            String dataStr = resultJson.getString(Constants.DATA);
            resultJson.putAll(JSONObject.parseObject(dataStr));
        }
        resultJson.remove(Constants.DATA);
        T resp = JSON.toJavaObject(resultJson, request.getResponseClass());
        return resp;
    }


    /**
     * Call the internal handler function of the gateway API
     *
     * @param request The request object
     * @return Response object
     * @throws OpenApiException
     */
    public FileUploadResponse uploadFile(FileUploadRequest request) throws OpenApiException {
        // Basic parameter check
        if (request == null) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "The parameter [request] cannot be null");
        }
        paramsCheck();

        FileBody fileBody = request.getFile_body();
        if (fileBody == null) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "The parameter [file_body] cannot be empty");
        }

        // Build common request header
        String httpRequestPsn = genHttpRequestId();
        Map<String, Object> reqHeaders = new HashMap<>();
        reqHeaders.put(Constants.HTTP_REQUEST_HEADER_PSN, httpRequestPsn);

        // Convert the request OpenApiRequest to JSON
        JSONObject requestParams = JSONObject.parseObject(JSON.toJSONString(request));
        // Build common request parameters
        buildCommonParameters(request, requestParams);
        requestParams.put("file_data_hash", DigestUtils.md5Hex(FileUtil.file2Byte(fileBody.getFile())));
        // Signature
        requestParams.put(Constants.SIGN, SignHandler.sign(appRsaPrivateKey, requestParams));

        Map<String, FileBody> fileMap = new HashMap<>(1);
        fileMap.put("file_data", fileBody);

        // Request gateway server Rest api
        String apiUrl = gatewayUrl + Constants.API_FILE_UPLOAD_URL;
        String resultStr;
        try {
            log.info("Request to gateway[" + apiUrl + "] send data [Http-Request-Psn = " + httpRequestPsn + "] -->> " + requestParams.toJSONString());

            resultStr = HttpClientUtil.doPostFile(apiUrl, reqHeaders, requestParams, fileMap);

            log.info("Response from gateway[" + apiUrl + "] receive data [Http-Request-Psn = " + httpRequestPsn + "] <<-- " + resultStr);
        } catch (Exception e) {
            log.error("Request to gateway[" + apiUrl + "] fail", e);
            throw new OpenApiException(Constants.REQUEST_SERVER_FAILED, "Request to gateway fail");
        }
        JSONObject resultJson = JSONObject.parseObject(resultStr);

        // Verify signature
        if (!SignHandler.verifySign(gatewayRsaPublicKey, resultJson)) {
            throw new OpenApiException(Constants.VERIFY_SIGNATURE_FAILED, "Response data signature error");
        }

        // Convert the returned JSON to OpenApiResponse
        Object data = resultJson.get(Constants.DATA);
        if (data != null) {
            String dataStr = resultJson.getString(Constants.DATA);
            resultJson.putAll(JSONObject.parseObject(dataStr));
        }
        resultJson.remove(Constants.DATA);
        FileUploadResponse resp = JSON.toJavaObject(resultJson, FileUploadResponse.class);
        return resp;
    }

    private void paramsCheck() throws OpenApiException {
        if (StringUtils.isBlank(appId)) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "The parameter [appId] cannot be empty");
        }
        if (StringUtils.isBlank(gatewayUrl)) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "The parameter [gatewayUrl] cannot be empty");
        }
        if (StringUtils.isBlank(gatewayRsaPublicKey)) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "You are using the RSA signature method,The parameter [gatewayRsaPublicKey] cannot be empty");
        }
        if (StringUtils.isBlank(appRsaPrivateKey)) {
            throw new OpenApiException(Constants.PARAMETER_IS_EMPTY, "You are using the RSA signature method,The parameter [appRsaPrivateKey] cannot be empty");
        }
    }

    private <T extends OpenApiResponse> void buildCommonParameters(OpenApiRequest<T> request, JSONObject requestParams) {
        requestParams.put(Constants.APP_ID, appId);
        requestParams.put(Constants.METHOD, request.getRequestMethod());
        requestParams.put(Constants.FORMAT, Constants.FORMAT_JSON);
        requestParams.put(Constants.CHARSET, Constants.CHARSET_UTF8);
        requestParams.put(Constants.SIGN_TYPE, Constants.SIGN_TYPE_RSA2);
        requestParams.put(Constants.VERSION, Constants.VERSION_VALUE);
        requestParams.put(Constants.TIMESTAMP, getUTCTimeStr());
        requestParams.remove("responseClass");
        requestParams.remove("requestMethod");
    }

    private String genHttpRequestId() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        String timeStr = format.format(new Date());
        int randomNum = (int) (Math.random() * Integer.MAX_VALUE);
        String str = timeStr + randomNum;
        int len = str.length();
        if (len < 20) {
            str += "00000000000000000000".substring(len);
        }
        return str;
    }

    private static String getUTCTimeStr() {
        Calendar cal = Calendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("GMT");
        cal.setTimeZone(tz);
        return String.valueOf(cal.getTimeInMillis());
    }

}
