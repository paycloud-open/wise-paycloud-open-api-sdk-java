import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.encryption.EncryptionHandler;
import com.wiseasy.openapi.request.*;
import com.wiseasy.openapi.response.*;
import org.junit.Test;

public class APITest {
    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCqYYFrbdXFhOv3zEo4fmORUmYKsadE/QMJhD5kGzthsfwvMoqJHzN41rrGWOp4ljL64elsd2amgnEkWi8ImtV9hS4IKLft/Lq0oP5OBUvbqldaG6KX5wjq7Q11W7Ec5/tSX0IdAtV++UaO/IJyydn2JNZjspeSxbUuE+cymGs9sXtO5s5wRQmeJWv3VhDzQMj8N0ptD2dVvoFkKZ7lbnpNo9ULwAn2oVQgLrmEv/R+TEZPiAcCIhcez4eimY9i6ucTcj4I9liUeTgydAnNAesQZDCt3qQyfl8EZvfWtCUVVbin4uiYsxbzcFSW3q0q27fLsruPRGf+XHnjbR4438MpAgMBAAECggEAMo4YDr5abe9Q7QgLBdRKyvX+HTI1hbzlR8+bi6yg5A4h3AdNH/7IERT1+qCrgfhfTB34WxzaspGF7Nltl0oKCuKXlAgw+0bAR5R1oMTli1px7OTCS/xbowmPssDwPrl+0yQ8w8rxemmQzCCUvGa0a9rmWlLFsuFDL1bshRDA0V73/RB+GG2GtYQFwcu9RgbWcb8YUXBkck7UccGfSoLhtiiDISYTcQy7FQUZHXrr/v6BapG/oVp0PXwIyglw44rHFbpAQVFZw7SzEJcJmLj3PPZkzTGOEPB1b+4Mv0jQszKx+O2whbziXoZGaBWW7jsozi07f0+xom8vWUOd0GhgWQKBgQD97kSx4U2PlnCOvVjHAXWAqBmw2L4gngoCQndWZTTx95nAX4OUUKljWWJhC1/9x/21l52SZhO3q/TAgHON42zIf/1PSDaUuhTATAqrHCgudpRTVd9X1bvJItXNvmbLKkb2hXUPnrd2DxasZI8YAgp6CJFmH+g5plrKF90y1JahowKBgQCrxPEO1CpG/Xso7PuW9fqdz+wS2F6S9UXFm4V0+CcL49ieCY7ImOFtXsTJjQrZEQE7DhONjic07Xd1xlyFjY6RJ5FlFSPGoU3rmbaDKPvcK65nNaH/Nf8V1iWZqTl5Cg4jKboNRilVtAcF+hJNC7jmOdk/kxLDLobxN7XYiiUMwwKBgQCNSrDqkUTI6pqCshTd1o/9IIv6/P79wzIqg7VHW1UUdgMVKZBbTG6UGz5EZUHqQgeHrW898JJ0Frg/DLo/bxYukhjurm3AX7IANc+R2j75a32oyRVXGFQ+3KU+r/0ees21ihjSsiu/AzJIhkOgxjHyKSZOPt7GhSvrW0/3YpbWJQKBgGBJ3F/Vq4V0HxBIGJj9dun0XoAJ7qou+FfX4K47VZgit5GQBgyJNwVadLIPcJ9SGwCB2ZAmue+/lpHdCoyLV/oi1ix190Intkh2OIu588XubqvIsvEf0cjp7NYAuQkTC+3GPFeolw9GBhHhp1StV48nqpMq3P+xG1ApTLUAa9iFAoGAQrbQRkq3TIbsTYIpxE5kM5fgHaaHlcg6qoiLzHuEidWXVa3PssJQnJs5jKGFcErWjn3o3ttfrllk3mm5MzJCChse9a54/KifNhCeDcCQHl/+WPswRBjYz5rw5XJacmz7S8rd7JEEXT2fY3uv47ey4N9CZaWw+Y0UzQ8MeAAJ5jY=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz715fc0d10ee9d156";
    private static final String SANDBOX_GATEWAY_URL = "http://gw.wisepaycloud.com";

    @Test
    public void ECROrderSale() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        WisehubCloudPayOrderRequest request = new WisehubCloudPayOrderRequest();
        request.setMerchant_no("302100085224");
        request.setStore_no("4021000637");
        request.setTerminal_sn("WPHK002352000111");
        request.setPrice_currency("JPY");
        request.setMessage_receiving_application("WISECASHIER");
        request.setPay_scenario("SWIPE_CARD");
        request.setPay_method_id("Visa");
        request.setPrice_currency("ZAR");
        request.setOrder_amount(5052.34);
        request.setTip_amount(10.00);
        request.setTrans_type(1);
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setDescription("IPhone 12 5G White");
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setExpires(300);
        request.setReject_trade_when_terminal_offline(false);
        request.setRequired_terminal_authentication(false);
        request.setApi_version("2.0");

        // Build a response object
        WisehubCloudPayOrderResponse response;
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
    public void ECROrderClose() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        WisehubCloudPayCloseRequest request = new WisehubCloudPayCloseRequest();
        request.setMerchant_no("302100085224");
        request.setStore_no("4021000637");
        request.setTerminal_sn("WPHK002352000111");
        request.setMessage_receiving_application("WISECASHIER");
        request.setMerchant_order_no("TEST_172291683847711");
        request.setDescription("Cancel");

        WisehubCloudPayCloseResponse response;
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
    public void QRMpm() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        CscanbPayGetqrcodeRequest request = new CscanbPayGetqrcodeRequest();
        request.setMerchant_no("302100085224");
        request.setStore_no("4021000637");
        request.setTerminal_sn("WPHK002352000111");
        request.setPay_method_id("ScanToPay2");
        request.setMerchant_order_no("TEST_172291683847711");
        request.setPrice_currency("ZAR");
        request.setOrder_amount(50.34);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");

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
    public void MCheckout() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        PayMerchantCheckoutRequest request = new PayMerchantCheckoutRequest();
        request.setMerchant_no("302100085224");
        request.setStore_no("4021000637");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("ZAR");
        request.setOrder_amount(150.34);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setReturn_url("https://www.google.com/");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");
        JSONObject card = new JSONObject();
        card.put("card_type", "CREDIT");
        card.put("pan", "4895749143709709");
        card.put("expiry", "1224");
        card.put("cvv", "1224");
        card.put("holder", "jack");
        // Encrypt the card information
        try {
            request.setCard(EncryptionHandler.encryptByPublicKey(card.toJSONString().getBytes(), GATEWAY_RSA_PUBLIC_KEY));
        } catch (Exception e) {
            // Handle encryption exceptions ......
            // @TODO
            throw new RuntimeException(e);
        }

        PayMerchantCheckoutResponse response;
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
    public void Checkout() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        PayPaycloudCheckoutRequest request = new PayPaycloudCheckoutRequest();
        request.setMerchant_no("302100085224");
        request.setStore_no("4021000637");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("ZAR");
        request.setOrder_amount(150.34);
        request.setExpires(300);
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setReturn_url("https://www.google.com/");
        request.setTerm_ip("127.0.0.1");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("30.5595");
        request.setLongitude("22.9375");

        PayPaycloudCheckoutResponse response;
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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerchant_no("302100085224");
        request.setMerchant_order_no("TEST_17229141143221");

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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderRefundSubmitRequest request = new OrderRefundSubmitRequest();
        request.setMerchant_no("302100085224");
        request.setOrig_merchant_order_no("TEST_1723008936362");
        request.setMerchant_order_no("TEST_REFUND_" + System.currentTimeMillis());
        request.setPrice_currency("ZAR");
        request.setOrder_amount(5000.34);
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
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderRefundQueryRequest request = new OrderRefundQueryRequest();
        request.setMerchant_no("302100085224");
        request.setMerchant_order_no("TEST_REFUND_17230125966221");

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
    public void DebicheckSubmit() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        DebicheckOrderCreateRequest request = new DebicheckOrderCreateRequest();
        request.setMerchant_no("302100085224");
        request.setTerminal_sn("WPHK002352000111");
        request.setMessage_receiving_application("WISECASHIER");
        request.setContract_reference_number("CRN20240809002");
        request.setCreditor_name("Jack");
        request.setDebtor_identification_number("8409100087084");
        request.setMaximum_amount(12000.00);
        request.setInstallment_amount(1000.00);
        request.setAccount_no("9051737590");
        request.setFirst_collection_date("2024-08-25");
        request.setMonthly_collect_date("25");
        request.setNotify_url("https://m.website.com/debicheck/notify/");

        DebicheckOrderCreateResponse response;
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
    public void DebicheckCancel() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        DebicheckOrderCancelRequest request = new DebicheckOrderCancelRequest();
        request.setMerchant_no("302100085224");
        request.setTerminal_sn("WPHK002352000111");
        request.setMessage_receiving_application("WISECASHIER");
        request.setSerial_no("DC0000000296");

        DebicheckOrderCancelResponse response;
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
    public void DebicheckQuery() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        DebicheckOrderQueryRequest request = new DebicheckOrderQueryRequest();
        request.setMerchant_no("302100085224");
        request.setTerminal_sn("WPHK002352000111");
        request.setSerial_no("DC0000000296000");

        DebicheckOrderQueryResponse response;
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
