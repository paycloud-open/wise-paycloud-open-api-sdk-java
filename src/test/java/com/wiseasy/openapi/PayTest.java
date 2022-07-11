package com.wiseasy.openapi;


import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.request.*;
import com.wiseasy.openapi.response.*;
import com.wiseasy.openapi.utils.Constants;
import org.junit.Test;

public class PayTest {

    //实例化客户端
    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJ9N8YTm0wEuBye5zSiZKncNIg6WBvTHjg4dYc9BH0zR+LeHd/jVo+InrMiIFgblnf7eYJ/wlPG5cSMMSyQMHj/7o0prc+VZsqi1mjX88InK4qDl6qFBFrg4dRrCAwILLVOP/ppUU3souMmnYnvOSUyuLBnhSno8qTpFSbcFAkPaHRmUmcTtVPWuNNbPaZVlNn81imIIVw8LKzOzCz9CNNcikkvbUlZp/cZ0Fl3s6icqOCjRvamg8KLZJs9D52S20X60ynreEIn8g6lr77byOGCCRwpdMl9Cl89WmbC3A3RKh7GRPtjyx3B5aQqE3sK5sNT8H8/EqcnQe8QoVBs7x1AgMBAAECggEAbE6vB+oqlt97DuY1TKVtWb+dePFAIKEtFYC4FKsZndOcvGaripxzCO0Q85sH16lLLh8bxyVPLag/hqx7AGcO0e1nRwbMPkf/NfuJOFZzuBMqOSJm96ghtQLiLiCwdJh3Ticd41U5bmziWlS6BqCp5JcUR2XQWXyiAh+1vQMEKC56CNPxr7imXITS7BYdY0qiGiOANcoEJhfQXn4BjzEm2FJufdlHW6/IeRYZ874HF3/7aUOyhbnapxYHU9PzicMc9XwerMcXMGvOfTUnCtRVONLn7jiknbpwdZ1d8PoItUZuaXdAyY6wFHZF+KvyrEoOV0eWRYzPgku2oSMD7IckUQKBgQDy+etogil+3F8S/qW1WiG6l2tLx5cwq3Ak9weN1zOo8A43obtXRxW2b4fDeol8y6LmYaIW9kKmK0qHEx5LoUSH7VN3FigNpFSa6muVJUuY+ob4H3Je+h3PaqbwhVFzjDofuIolPiJZW64LaFPZcxxD9vM2tZ6txLeMUmGftPoVSwKBgQCRWeNxbvTs8U5UknrdDZHUwXUmy5Qg2LUzxDXdbZXgolMh0AgDShcEFvaF+G3OFHj9vovytt0HtEXyC9LEc6w/a08mtGHiAJbjyjrJCHRNrcFflEm1xseIqXQXDj5Tw05XkAnlWN+r0w3Ix45+GrNhMOGfDkVyQeYI5Jsxxt0dPwKBgFJwcWr4HtQoOSnctKSffCovDfycL7QXtukT18BMb/611F0TxtiKCdfoZ4vvm454GUFJhxF7ZIm0zoid9/15LiNgZp1VKynVw878Epx8FvZEql6tbMTE4DBr41BgK46k2WPB3T1do5HmBVthfnGdGM4Gj+bUII6c3BoEKZNieCeZAoGAQ3rx5wXWW/KjpQvkUqAsJhQyqXI2MRGq/n+Hamen/4QdCEOmlLBfAx0OEqCFifljOpquKl7POvZsyrTGg0IYo9DUDGoOT3hqlRKcPBzasf2LGy6jEetZU48oQFPyh7zSsEBE999M6F6xtZdABjerM+IXvVpIz4TcoSBRFMj4es0CgYEAiNCbs2YPKBFpJq9EYsSsx0GwXAItXFAM71TogWs/8InGNq0PYRZTn9Lq6mFEyLkFql1zWQkS7CG3uDPBV+V2G4MbvoZeFgiQmly7uMQJwbEiKjJBsOzkYY2ZhFYLjGUpGer2U82XeEU6F/Vh4FLkVEE2iB3nPpVQs0qPZxfFZvM=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz9f2a175d0e0ef632";

    /**
     * Merchants scan the QR code and customers pay
     */
    @Test
    public void BScanC() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        BscancPaySubmitRequest request = new BscancPaySubmitRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100008432");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("USD");
        request.setTrans_amount(200.06);

        request.setAuth_code("6850186537112578202087927");

        request.setPay_method_id("Coopay");
        request.setDescription("IPhone 12 5G White");

        BscancPaySubmitResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
    }

    /**
     * Customers scan the QR code and pay
     */
    @Test
    public void CScanB() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        CscanbPayGetqrcodeRequest request = new CscanbPayGetqrcodeRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setStore_no("4021000201");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setTrans_amount(1.0);
        request.setPay_method_id("WeChatPay");
        request.setDescription("test");

        CscanbPayGetqrcodeResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
        System.err.println("qrcode_url:  " + response.getQrcode_url());
    }

    /**
     * Unified Order
     */
    @Test
    public void unifiedOrder() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        PayUnifiedorderRequest request = new PayUnifiedorderRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setStore_no("4022000019");
        request.setPrice_currency("JPY");
        request.setTrans_amount(1.0);
        request.setPay_method_id("WeChatPay");
        request.setDescription("IPhone 12 5G White");
        request.setExpires(300);
//        request.setTerm_ip("127.0.0.1");
        request.setTerminal_type("WAP");
        request.setReturn_url("https://www.baidu.com");
//        request.setNotify_url("https://www.baidu.com");
        request.setOs_type("ANDROID");
//        request.setAttach("189010-1--0991");
//        request.setBrowser_head_user_agent("123");
        request.setWechatpay_product_type("JSAPI");
//        request.setSub_appid("wx1ecb12ce90814a77");
//        request.setSub_openid("isjskoalll");

        PayUnifiedorderResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
        System.err.println("pay_url:  " + response.getPay_url());
    }

    /**
     * Unified Order
     */
    @Test
    public void entryCodePay() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        PayEntrycodeRequest request = new PayEntrycodeRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setStore_no("4021000201");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setTrans_amount(100.00);
//        request.setPay_method_id("Alipay+");
        request.setDescription("IPhone 12 5G White");
        request.setExpires(300);
        request.setTerm_ip("127.0.0.1");
        request.setReturn_url("https://www.baidu.com");
//        request.setNotify_url("https://www.baidu.com");
        request.setOs_type("ANDROID");
        request.setAttach("189010-1--0991");
        request.setBrowser_head_user_agent("AlipayConnect");

        PayEntrycodeResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
        System.err.println("pay_url:  " + response.getPay_url());
    }

    /**
     * orderquery
     */
    @Test
    public void orderquery() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderQueryRequest request = new OrderQueryRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("TEST_1654765371046");

        OrderQueryResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
        System.err.println("trans_status:  " + response.getTrans_status());
    }

    /**
     * orderRevoker
     */
    @Test
    public void orderRevoker() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderRevokerRequest request = new OrderRevokerRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("TEST_1654765371046");

        OrderRevokerResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
    }

    /**
     * orderRefund
     */
    @Test
    public void orderRefund() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderRefundSubmitRequest request = new OrderRefundSubmitRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setOrig_merchant_order_no("TEST_1654765874687");
        request.setMerchant_order_no("TEST_16547658746871_2");
        request.setTrans_amount(100.00);
        request.setDescription("test refund");

        OrderRefundSubmitResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
        System.err.println("trans_no:  " + response.getTrans_no());
    }

    /**
     * orderRefund
     */
    @Test
    public void orderRefundQuery() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderRefundQueryRequest request = new OrderRefundQueryRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100002572");
        request.setMerchant_order_no("TEST_1623925902130_002");

        OrderRefundQueryResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
        System.err.println("trans_no:  " + response.getTrans_end_time());
    }

    /**
     * Mini Program Payment
     */
    @Test
    public void miniprogramPay() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        PayMiniprogramOrderRequest request = new PayMiniprogramOrderRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setTrans_amount(1.00);
        request.setPay_method_id("WeChatPay");
        request.setDescription("IPhone 12 5G White");
        request.setSub_appid("wx1ecb12ce90814a77");
        request.setSub_openid("wx89101kslslsuh1091891");

        PayMiniprogramOrderResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
    }


    /**
     * In-App Payment
     */
    @Test
    public void inAppPay() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        PayInappOrderRequest request = new PayInappOrderRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setTrans_amount(1.00);
        request.setPay_method_id("WeChatPay");
        request.setDescription("IPhone 12 5G White");
        request.setSub_appid("wx594b90e8170abfc5");
        request.setOs_type("1");

        PayInappOrderResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
    }

    /**
     * customs declaration
     */
    @Test
    public void customsDeclaration() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        CustomsDeclarationRequest request = new CustomsDeclarationRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("50210004102110180000021");
        request.setCustoms_declaration_request_id("" + System.currentTimeMillis());
        request.setCustoms_declaration_request_type(1);
        request.setCustoms("GUANGZHOU_ZS");
        request.setMerchant_customs_no("3106949395");
        request.setMerchant_customs_name("wiseasy");
        request.setCurrency("CNY");
        request.setCustoms_declaration_amount(0.05);
        request.setIs_split(false);
        request.setCertificate_type("IDCARD");
        request.setCertificate_id("513022198807124918");
        request.setCertificate_name("张三");

        CustomsDeclarationResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
    }

    /**
     * customs declaration
     */
    @Test
    public void customsDeclarationQuery() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        CustomsDeclarationQueryRequest request = new CustomsDeclarationQueryRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100041048");
        request.setMerchant_order_no("50210004102110180000021");
        request.setCustoms_declaration_request_id("" + System.currentTimeMillis());
        request.setCustoms("GUANGZHOU_ZS");

        CustomsDeclarationQueryResponse response;
        try {
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
            System.err.println();
            System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Interface failed to execute, error message printed
            System.err.println();
            System.err.println("api execute error:  " + JSON.toJSONString(response));
        }
    }

    /**
     * Unified Order
     */
    @Test
    public void unifiedOrder2() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        PayUnifiedorderRequest request = new PayUnifiedorderRequest();

        request.setMerchant_no("302100008432");

        try {
            PayUnifiedorderResponse response = openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    /**
     *
     */
    @Test
    public void wisehubCloudMessageSend() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        WisehubCloudMessageSendRequest request = new WisehubCloudMessageSendRequest();

        request.setMerchant_no("302100008432");
        request.setTerminal_sn("PP35272137000547");
        request.setMerchant_request_id("" + System.currentTimeMillis());
        request.setLanguage("zh-CN");
        request.setVoice_content("微信收款100元");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    /**
     *
     */
    @Test
    public void payBillDownload() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        PayBillDownloadRequest request = new PayBillDownloadRequest();


        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    @Test
    public void wisehubCloudPayOrder() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        WisehubCloudPayOrderRequest request = new WisehubCloudPayOrderRequest();

        request.setMerchant_no("302100008432");
        request.setTerminal_sn("PP35272137000547");
        request.setMerchant_order_no("" + System.currentTimeMillis());
        request.setPay_method_category("QR_B_SCAN_C");
        request.setPay_method_id("Coopay");
        request.setPrice_currency("USD");
        request.setTrans_amount(1.0);
        request.setTrans_type(1);
        request.setDescription("测试交易");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    /**
     *
     */
    @Test
    public void autoDebitSign() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        AutoDebitSignRequest request = new AutoDebitSignRequest();
        request.setMerchant_no("302100041048");
        request.setStore_no("4021000418");
        request.setPay_method_id("Alipay+");
        request.setSub_pay_method_id("Alipay");
        request.setOut_contract_code("C20220016");
        request.setTerminal_type("WAP");
        request.setUser_client_ip("117.173.221.110");
        request.setNotify_url("https://www.baid.com");
        request.setReturn_url("https://www.baid.com");
        request.setExpires(1800);
        request.setUser_display_name("李切");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    @Test
    public void autoDebitSignQuery() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        AutoDebitSignQueryRequest request = new AutoDebitSignQueryRequest();
        request.setMerchant_no("302100041048");
        request.setStore_no("4021000418");
        request.setPay_method_id("Alipay+");
        request.setSub_pay_method_id("Alipay");
        request.setOut_contract_code("C202200150");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    @Test
    public void autoDebitCancel() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        AutoDebitCancelRequest request = new AutoDebitCancelRequest();
        request.setMerchant_no("302100041048");
        request.setStore_no("4021000418");
        request.setPay_method_id("Alipay+");
        request.setSub_pay_method_id("Alipay");
        request.setContract_id("281666031081861654744228000brhucIElWhP3lF50003D9");
        request.setTermination_note("解约");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    @Test
    public void autoDebitPay() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        AutoDebitPaySubmitRequest request = new AutoDebitPaySubmitRequest();
        request.setMerchant_no("302100041048");
        request.setStore_no("4021000418");
        request.setPay_method_id("Alipay+");
        request.setSub_pay_method_id("Alipay");
        request.setContract_id("281666031083071654765308000if7UxmNWNokG1Yu0003D9");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setTrans_amount(100.00);
        request.setDescription("IPhone 12 5G White");
        request.setExpires(300);
        request.setTerm_ip("198.87.12.1");
        request.setNotify_url("https://www.baid.com");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

    @Test
    public void merchantOnboarding() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        MerchantOnboardingRequest request = new MerchantOnboardingRequest();
        request.setInstitution_no("100012278");
        request.setOut_merchant_no("M0019871555");
        request.setMerchant_name("Local is Lekker TuckShop 005");
        request.setMerchant_full_name("Local is Lekker TuckShop Ltd.");
        request.setMerchant_type("Enterprise");
        request.setRegistration_certificate_number("zs08190671881");
        request.setRegistration_certificate_date("2029-12-31");
        request.setPrincipal_name("zhang san");
        request.setPrincipal_id_number("51302881990106181");
        request.setPrincipal_certificate_date("2035-06-01");
        request.setMcc("3024");
        request.setCountry("ZAF");
        request.setAddress_detail("china sichuan chengdu tianfuguangchang 23");
        request.setSales_employee_email("huke@wiseasy.com");
        request.setBusiness_type("In-store");
        request.setContact_name("zhang san");
        request.setContact_phone("27 1817819");
        request.setContact_email("37150071@gmail.com");
        request.setOut_store_no("S00919251");
        request.setStore_name("TuckShop 0051");
        request.setStore_address_detail("china sichuan chengdu tianfuguangchang 23-002");
        request.setTerminal_sn("P9779190761551");
        request.setDebit_rate("2.5");
        request.setCredit_rate("3");
        request.setOpen_vat(true);
        request.setOpen_settle(true);
        request.setSettlement_cycle("D+7");
        request.setAccount_no("6217567189001771991");
        request.setAccount_holder("zhang san");
        request.setAccount_branch("Absa");
        request.setMid("7890078916");
        request.setTid("781990");

        try {
            MerchantOnboardingResponse response = openapiClient.execute(request);
            System.out.println(response.toString());
        } catch (OpenApiException e) { return;
        }
    }

    @Test
    public void merchantQuery() {
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        MerchantQueryRequest request = new MerchantQueryRequest();
        request.setInstitution_no("100012278");
        request.setOut_merchant_no("M0019871555");

        try {
            openapiClient.execute(request);
        } catch (OpenApiException e) { return;
        }
    }

}
