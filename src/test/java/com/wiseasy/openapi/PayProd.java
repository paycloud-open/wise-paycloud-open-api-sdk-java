package com.wiseasy.openapi;


import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.request.*;
import com.wiseasy.openapi.response.*;
import com.wiseasy.openapi.utils.Constants;
import org.junit.Test;

public class PayProd {

    //实例化客户端
    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJ9N8YTm0wEuBye5zSiZKncNIg6WBvTHjg4dYc9BH0zR+LeHd/jVo+InrMiIFgblnf7eYJ/wlPG5cSMMSyQMHj/7o0prc+VZsqi1mjX88InK4qDl6qFBFrg4dRrCAwILLVOP/ppUU3souMmnYnvOSUyuLBnhSno8qTpFSbcFAkPaHRmUmcTtVPWuNNbPaZVlNn81imIIVw8LKzOzCz9CNNcikkvbUlZp/cZ0Fl3s6icqOCjRvamg8KLZJs9D52S20X60ynreEIn8g6lr77byOGCCRwpdMl9Cl89WmbC3A3RKh7GRPtjyx3B5aQqE3sK5sNT8H8/EqcnQe8QoVBs7x1AgMBAAECggEAbE6vB+oqlt97DuY1TKVtWb+dePFAIKEtFYC4FKsZndOcvGaripxzCO0Q85sH16lLLh8bxyVPLag/hqx7AGcO0e1nRwbMPkf/NfuJOFZzuBMqOSJm96ghtQLiLiCwdJh3Ticd41U5bmziWlS6BqCp5JcUR2XQWXyiAh+1vQMEKC56CNPxr7imXITS7BYdY0qiGiOANcoEJhfQXn4BjzEm2FJufdlHW6/IeRYZ874HF3/7aUOyhbnapxYHU9PzicMc9XwerMcXMGvOfTUnCtRVONLn7jiknbpwdZ1d8PoItUZuaXdAyY6wFHZF+KvyrEoOV0eWRYzPgku2oSMD7IckUQKBgQDy+etogil+3F8S/qW1WiG6l2tLx5cwq3Ak9weN1zOo8A43obtXRxW2b4fDeol8y6LmYaIW9kKmK0qHEx5LoUSH7VN3FigNpFSa6muVJUuY+ob4H3Je+h3PaqbwhVFzjDofuIolPiJZW64LaFPZcxxD9vM2tZ6txLeMUmGftPoVSwKBgQCRWeNxbvTs8U5UknrdDZHUwXUmy5Qg2LUzxDXdbZXgolMh0AgDShcEFvaF+G3OFHj9vovytt0HtEXyC9LEc6w/a08mtGHiAJbjyjrJCHRNrcFflEm1xseIqXQXDj5Tw05XkAnlWN+r0w3Ix45+GrNhMOGfDkVyQeYI5Jsxxt0dPwKBgFJwcWr4HtQoOSnctKSffCovDfycL7QXtukT18BMb/611F0TxtiKCdfoZ4vvm454GUFJhxF7ZIm0zoid9/15LiNgZp1VKynVw878Epx8FvZEql6tbMTE4DBr41BgK46k2WPB3T1do5HmBVthfnGdGM4Gj+bUII6c3BoEKZNieCeZAoGAQ3rx5wXWW/KjpQvkUqAsJhQyqXI2MRGq/n+Hamen/4QdCEOmlLBfAx0OEqCFifljOpquKl7POvZsyrTGg0IYo9DUDGoOT3hqlRKcPBzasf2LGy6jEetZU48oQFPyh7zSsEBE999M6F6xtZdABjerM+IXvVpIz4TcoSBRFMj4es0CgYEAiNCbs2YPKBFpJq9EYsSsx0GwXAItXFAM71TogWs/8InGNq0PYRZTn9Lq6mFEyLkFql1zWQkS7CG3uDPBV+V2G4MbvoZeFgiQmly7uMQJwbEiKjJBsOzkYY2ZhFYLjGUpGer2U82XeEU6F/Vh4FLkVEE2iB3nPpVQs0qPZxfFZvM=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz715fc0d10ee9d156";

    /**
     * Merchants scan the QR code and customers pay
     */
    @Test
    public void BScanC() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        BscancPaySubmitRequest request = new BscancPaySubmitRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100001801");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("MMK");
        request.setTrans_amount(20.00);
        request.setAuth_code("hQVDUFYwMWFTTwigAAADMwEBAVcOYjB0YAETZ2lDHVASIB9jM4ICAACfEBEHAQEDoAAAAQgwMDI1MDAwMZ8mCFZaEvQgV7lknycBgJ82Ai39nzcEb8MUal80AQE=");
        request.setPay_method_id("UnionPay");
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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        CscanbPayGetqrcodeRequest request = new CscanbPayGetqrcodeRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100001801");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("MMK");
        request.setTrans_amount(10.00);
        request.setPay_method_id("UnionPay");
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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        PayUnifiedorderRequest request = new PayUnifiedorderRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100000164");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("USD");
        request.setTrans_amount(10000.00);
//        request.setPay_method_id("GCash");
        request.setDescription("IPhone 12 5G White");
        request.setExpires(300);
        request.setTerm_ip("127.0.0.1");
        request.setTerminal_type("WEB");
        request.setReturn_url("https://www.baidu.com");
//        request.setNotify_url("https://www.baidu.com");
        request.setOs_type("ANDROID");
        request.setAttach("189010-1--0991");

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
     * orderquery
     */
    @Test
    public void orderquery() {
        for (int i = 0; i < 1; i++) {

            //  Instantiate the client
            OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

            //  Instantiate the request class corresponding to the specific API.
            //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
            OrderQueryRequest request = new OrderQueryRequest();

            //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
            request.setMerchant_no("312100000164");
            request.setMerchant_order_no("TEST_1624959012842");

            OrderQueryResponse response;
            try {
                response = openapiClient.execute(request);
            } catch (OpenApiException e) {
                // The call failed with an error message printed
                System.err.println();
                System.err.println("request api error:" + e.getErrCode() + "->>" + e.getErrMsg());
                if(e.getErrCode().equals(Constants.REQUEST_SERVER_FAILED)){
                    break;
                }
                return;
            }
            if (!response.isSuccess()) {
                // Interface failed to execute, error message printed
                System.err.println();
                System.err.println("api execute error:  " + JSON.toJSONString(response));
            }
            System.err.println("trans_status:  " + response.getTrans_status());
        }
    }

    /**
     * orderRevoker
     */
    @Test
    public void orderRevoker() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderRevokerRequest request = new OrderRevokerRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100000164");
        request.setMerchant_order_no("TEST_1624959012842");

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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderRefundSubmitRequest request = new OrderRefundSubmitRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100000164");
        request.setOrig_merchant_order_no("e98d89654dba4e21a2bacbf8572bcaac");
        request.setMerchant_order_no("TEST_REFUND_e98d89654dba4e21a2bacbf8572bcaac2");
        request.setTrans_amount(982.00);
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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        OrderRefundQueryRequest request = new OrderRefundQueryRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100000164");
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
     * In-App Payment
     */
    @Test
    public void inAppPay() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        PayInappOrderRequest request = new PayInappOrderRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312100006053");
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

    @Test
    public void customsDeclaration() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, Constants.GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        //  The class name corresponds to the interface name, and the name of the current calling interface: paycloud.pay.barcodepay
        CustomsDeclarationRequest request = new CustomsDeclarationRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("312200046972");
        request.setMerchant_order_no("1022060714520001");
        request.setCustoms_declaration_request_id("" + System.currentTimeMillis());
        request.setCustoms_declaration_request_type(4);
        request.setCustoms("GUANGZHOU_ZS");
        request.setMerchant_customs_no("3106949395");
        request.setMerchant_customs_name("亚堂科技（上海）有限公司");
        request.setCurrency("CNY");
        request.setCustoms_declaration_amount(1138.6400);
        request.setIs_split(true);
        request.setSub_merchant_order_no("220618-V146");
        request.setSub_order_amount(1138.6400);
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

}
