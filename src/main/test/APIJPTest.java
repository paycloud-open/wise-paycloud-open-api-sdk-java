import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.request.*;
import com.wiseasy.openapi.response.*;
import org.junit.Test;

public class APIJPTest {
    private static final String APP_RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMPiTuC1xHkCUu/TospfJ7IldcnqYWaB4L287ADssc91NJ0NHP9AXvepTee1StWxRVamcyH3yWRJSnsbTWRqE+tQWDZ21Rhg5AQ8KWZ9RpSK+f07eX1K0rMUl3xUouvJgWzWvHZlUoIqXBx76nU7upFo5CoKmnyXYrZ0K2hjM9+7cRXff4+LJ7Js7d8eFgMWKEm0IN+h4SMeRCuU5DgIXf4W0sUZuyFXiDuIbID1kArp9JnO5woSY/OYCM3PjesaXMLHunLR2hTj4yAYg2WVT85tsWCT+B3rBDhpuNgZhRrPn9cgzaHfXCfZrpX9B5uSleuFbUFCz+e7ZqSmQ0O5PJAgMBAAECggEAMy2KdIQYzNTBfQBT9m8oqd7CWr5ahdrA/DrenB/J52wqLMnThzvZ3qaxJO+E2y5doT4PIq9y27NzPC8RexCTTzroJCfeMN3m3XTc0d5aGYG49W5hlTq7ZwO5d8e7ZorURZ35Mu8ZLGhYbPrjjFR2KyJcD9xpjR1rzjMEmW8ny/o+z1nMMdt77bLddHVwVWqEMxuyy8DRIRcLU6yqQdrio+y6nt0fYjA5lKhiAhgcjehmNFAppeLGa0bZyUGnUsXEhHpfyvbGwVqh4m65RwXi1Z5dmBSusql05GLyp6qwYjPiwNRGMehmMLCIyYAKB7lDhWVvwk7inLrxHOnR4nKGwQKBgQDmGnd0L3PiVWL3uwsNeEXz0w3I8C3RJ5ehDc21pPtUIINXrakHtWTY+d15Ay1tqVAIp+IDi5jfyjD2RoE7Ejcgyk22EF7Sz7QVNJFvLVi6ILlbot/+tNMQreMs78fkYAFXms6HKpT4zNWwxc0oykjM8WUBlGrBGkst7NZHOk+V7QKBgQCcBrF4UOh4iEGEFFsb5IypgY5wAJnwU6ExwFS7nbzDzrPcbLicNxiKl3496UD8iCuMxr248tuHWFUrmzoJ4Q/JGrc02ttKQsBcUMuOlzR6ifUIAiTbKVsuZpWywIVWd0xFjSp9hvXIq0EjnqlaUYHLossJH6ZJNs8QImTtGsH5zQKBgQDi56J37ftGa5EGXWnOxJWmlK75QO7NW0+Iv8Xko2Y7VTxvj44pTdS+qdad6GY5x0Zm4rZbbKM5u3aAxJHXIGVAbn4nVQlMtQkOCCKKEZt3H6HpHTnpP4MK5Y4p1+Gz8IAiVUPnwjPZDJSElulymdckUb6ayjJjbXxJM00yO+wTGQKBgA72gVyFfdXZU1ckUJx7LZYv64YIOLsYehP4WufnN6wbjZos/wNUMVFRN/UeAnJ1aJ/Gi3lKKQ1wxjI5X7aE0+u4WSuDdZZIkoQH542UKJ87zbjn47r02162zdJnriHdrP3ajOGe6MFG0ydkVt9ng6gQw6HrXBoXXIIymjU25LVdAoGBAI+IFLPulppYH2vWZzi3RAykUsQ25AQKewEdGfyxTLXkiPs1Wj3eTymVK6V28/jPOggBfhIaxb1dgLucShz1NzoSjln2XOghp5Ze3LJOIX/NitA04xQN6PWPB0XOBW84DGJT+kcRvdH+OCJE3fadzt7W6C5JvZISUpeLa3/754xa";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz715fc0d10ee9d156";
    private static final String GATEWAY_URL = "https://open.n-age.co.jp";

    @Test
    public void QRMpm() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        CscanbPayGetqrcodeRequest request = new CscanbPayGetqrcodeRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4122000031");
        request.setPay_method_id("WeChatPay");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1d);
        request.setExpires(90);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setTerm_ip("117.172.47.151");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("35.41");
        request.setLongitude("139.44");

        CscanbPayGetqrcodeResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void QRCpm() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        BscancPaySubmitRequest request = new BscancPaySubmitRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4122000031");
        request.setAuth_code("132904600349929677");
        request.setPay_method_id("WeChatPay");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1d);
        request.setExpires(60);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setTerm_ip("117.172.47.151");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("35.41");
        request.setLongitude("139.44");

        BscancPaySubmitResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void InstoreMobileWebPayment() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        PayEntrycodeRequest request = new PayEntrycodeRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4122000031");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1D);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setReturn_url("https://www.google.com/");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");
        request.setOs_type("ANDROID");
        request.setBrowser_head_user_agent("Mozilla/5.0 (Linux; Android 13; SM-A526B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36");
        request.setLanguage("ja-JP");

        PayEntrycodeResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void PCWebPayment() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        PayUnifiedorderRequest request = new PayUnifiedorderRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4121000078");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1D);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setReturn_url("https://www.google.com/");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");
        request.setOs_type("ANDROID");
        request.setLanguage("ja-JP");
        request.setTerminal_type("WEB");

        PayUnifiedorderResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void MiniProgramPayment() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        PayMiniprogramOrderRequest request = new PayMiniprogramOrderRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4121000078");
        request.setPay_method_id("WeChatPay");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1D);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");
        request.setSub_appid("wx1234567890");
        request.setSub_openid("wx8888888888888888");

        PayMiniprogramOrderResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void AppPayment() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        PayInappOrderRequest request = new PayInappOrderRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4121000078");
        request.setPay_method_id("WeChatPay");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1D);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");
        request.setSub_appid("wx1234567890");
        request.setOs_type("IOS");

        PayInappOrderResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void OrderQuery() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerchant_no("312100007235");
        request.setMerchant_order_no("TEST_1735801442944");

        OrderQueryResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void Refund() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderRefundSubmitRequest request = new OrderRefundSubmitRequest();
        request.setMerchant_no("312100007235");
        request.setOrig_merchant_order_no("TEST_1735801442944");
        request.setMerchant_order_no("TEST_REFUND_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setOrder_amount(1d);
        request.setNotify_url("https://m.website.com/pay/notify/refund");
        request.setDescription("Product Quality Issues");

        OrderRefundSubmitResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void RefundQuery() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderRefundQueryRequest request = new OrderRefundQueryRequest();
        request.setMerchant_no("312100007235");
        request.setMerchant_order_no("TEST_REFUND_1735873100708");

        OrderRefundQueryResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void cancel() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderRevokerRequest request = new OrderRevokerRequest();
        request.setMerchant_no("312100007235");
        request.setMerchant_order_no("TEST_1735885114292");

        OrderRevokerResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void getexchage() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        ExchageRateGetRequest request = new ExchageRateGetRequest();
        request.setMerchant_no("312100007235");
        request.setStore_no("4122000031");
        request.setPay_method_id("WeChatPay");
        request.setLocal_currency("CNY");
        request.setForeign_currency("CNY");
        request.setDate("20250103");

        ExchageRateGetResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void customs() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        CustomsDeclarationRequest request = new CustomsDeclarationRequest();
        request.setMerchant_no("312100007235");
        request.setMerchant_order_no("TEST_CUSTOMS_" + System.currentTimeMillis());
        request.setCustoms_declaration_request_id("TEST_CUSTOMS_" + System.currentTimeMillis());
        request.setCustoms_declaration_request_type(1);
        request.setCustoms("SHENZHEN");
        request.setMerchant_customs_no("18918719091");
        request.setMerchant_customs_name("XX公司");
        request.setCurrency("CNY");
        request.setCustoms_declaration_amount(100d);
        request.setIs_split(false);

        CustomsDeclarationResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

    @Test
    public void customsQuery() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        CustomsDeclarationQueryRequest request = new CustomsDeclarationQueryRequest();
        request.setMerchant_no("312100007235");
        request.setMerchant_order_no("TEST_CUSTOMS_12345");
        request.setCustoms_declaration_request_id("TEST_CUSTOMS_12345");
        request.setCustoms("SHENZHEN");

        CustomsDeclarationQueryResponse response;
        try {
            // Execute the request
            response = openapiClient.execute(request);
        } catch (OpenApiException e) {
            // Handle network exceptions ......
            // @TODO
            System.err.println("\nrequest api error:" + e.getErrCode() + "->>" + e.getErrMsg());
            return;
        }
        if (!response.isSuccess()) {
            // Handle business exceptions ......
            // @TODO
            System.err.println("\napi execute error:  " + JSON.toJSONString(response));
        }

        // Write your business code based on the API response ......
        // @TODO
    }

}
