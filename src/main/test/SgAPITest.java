import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.request.CscanbPayGetqrcodeRequest;
import com.wiseasy.openapi.request.PayTokenQueryRequest;
import com.wiseasy.openapi.request.PayTokenSubmitRequest;
import com.wiseasy.openapi.request.PayUnifiedorderRequest;
import com.wiseasy.openapi.response.CscanbPayGetqrcodeResponse;
import com.wiseasy.openapi.response.PayTokenResponse;
import com.wiseasy.openapi.response.PayTokenSubmitResponse;
import com.wiseasy.openapi.response.PayUnifiedorderResponse;
import com.wiseasy.openapi.utils.EAuthType;
import org.junit.Test;

public class SgAPITest {

    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCqYYFrbdXFhOv3zEo4fmORUmYKsadE/QMJhD5kGzthsfwvMoqJHzN41rrGWOp4ljL64elsd2amgnEkWi8ImtV9hS4IKLft/Lq0oP5OBUvbqldaG6KX5wjq7Q11W7Ec5/tSX0IdAtV++UaO/IJyydn2JNZjspeSxbUuE+cymGs9sXtO5s5wRQmeJWv3VhDzQMj8N0ptD2dVvoFkKZ7lbnpNo9ULwAn2oVQgLrmEv/R+TEZPiAcCIhcez4eimY9i6ucTcj4I9liUeTgydAnNAesQZDCt3qQyfl8EZvfWtCUVVbin4uiYsxbzcFSW3q0q27fLsruPRGf+XHnjbR4438MpAgMBAAECggEAMo4YDr5abe9Q7QgLBdRKyvX+HTI1hbzlR8+bi6yg5A4h3AdNH/7IERT1+qCrgfhfTB34WxzaspGF7Nltl0oKCuKXlAgw+0bAR5R1oMTli1px7OTCS/xbowmPssDwPrl+0yQ8w8rxemmQzCCUvGa0a9rmWlLFsuFDL1bshRDA0V73/RB+GG2GtYQFwcu9RgbWcb8YUXBkck7UccGfSoLhtiiDISYTcQy7FQUZHXrr/v6BapG/oVp0PXwIyglw44rHFbpAQVFZw7SzEJcJmLj3PPZkzTGOEPB1b+4Mv0jQszKx+O2whbziXoZGaBWW7jsozi07f0+xom8vWUOd0GhgWQKBgQD97kSx4U2PlnCOvVjHAXWAqBmw2L4gngoCQndWZTTx95nAX4OUUKljWWJhC1/9x/21l52SZhO3q/TAgHON42zIf/1PSDaUuhTATAqrHCgudpRTVd9X1bvJItXNvmbLKkb2hXUPnrd2DxasZI8YAgp6CJFmH+g5plrKF90y1JahowKBgQCrxPEO1CpG/Xso7PuW9fqdz+wS2F6S9UXFm4V0+CcL49ieCY7ImOFtXsTJjQrZEQE7DhONjic07Xd1xlyFjY6RJ5FlFSPGoU3rmbaDKPvcK65nNaH/Nf8V1iWZqTl5Cg4jKboNRilVtAcF+hJNC7jmOdk/kxLDLobxN7XYiiUMwwKBgQCNSrDqkUTI6pqCshTd1o/9IIv6/P79wzIqg7VHW1UUdgMVKZBbTG6UGz5EZUHqQgeHrW898JJ0Frg/DLo/bxYukhjurm3AX7IANc+R2j75a32oyRVXGFQ+3KU+r/0ees21ihjSsiu/AzJIhkOgxjHyKSZOPt7GhSvrW0/3YpbWJQKBgGBJ3F/Vq4V0HxBIGJj9dun0XoAJ7qou+FfX4K47VZgit5GQBgyJNwVadLIPcJ9SGwCB2ZAmue+/lpHdCoyLV/oi1ix190Intkh2OIu588XubqvIsvEf0cjp7NYAuQkTC+3GPFeolw9GBhHhp1StV48nqpMq3P+xG1ApTLUAa9iFAoGAQrbQRkq3TIbsTYIpxE5kM5fgHaaHlcg6qoiLzHuEidWXVa3PssJQnJs5jKGFcErWjn3o3ttfrllk3mm5MzJCChse9a54/KifNhCeDcCQHl/+WPswRBjYz5rw5XJacmz7S8rd7JEEXT2fY3uv47ey4N9CZaWw+Y0UzQ8MeAAJ5jY=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz715fc0d10ee9d156";

    private static final String TEST_URL = "https://wiseasy-open.sg.wisepaycloud.com";

    private static final String PROD_URL = "https://wiseasy-open.sg.paycloud.world";

    /**
     Create an order through online payment and receive the payment page URL "pay_url" hosted on Wiseasy PayCloud.
     Redirect the user's request to this page and enter account and other information for secure payment.
     For more information, please refer to the document: https://gw.paycloud.world/docs/#/unifiedOrder
     Please refer to the documentation for Java SDK: https://gw.paycloud.world/docs/#/javaSDK
     For other development languages and API usage methods, please browse: https://gw.paycloud.world/docs/#/?id=readme
     */
    @Test
    public void rsaAuthTest() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, TEST_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        CscanbPayGetqrcodeRequest request = new CscanbPayGetqrcodeRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("322400004292");
        request.setStore_no("4224000028");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("JPY");
        request.setTrans_amount(11.0);
        request.setDescription("IPhone 15 5G White");
        request.setExpires(300);
        request.setTerm_ip("127.0.0.1");
        request.setPay_method_id("Alipay+");

        CscanbPayGetqrcodeResponse response;
        try {
            response = openapiClient.execute(request, EAuthType.RSA2);
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
        // Please redirect to the page shown in pay_URL, and the user will complete the remaining payment process
        System.err.println("pay_url:  " + response.getQrcode_url());
    }

    @Test
    public void basicAuthTest() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, TEST_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY, "ub89c59013640b3820b9b0a75763ba6f3", "pb53f5de5ba9951aa24fe47e753ce3345");

        //  Instantiate the request class corresponding to the specific API.
        PayUnifiedorderRequest request = new PayUnifiedorderRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("332400005419");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("USD");
        request.setTrans_amount(345.05);
        request.setDescription("IPhone 15 5G White");
        request.setExpires(300);
        request.setTerm_ip("127.0.0.1");
        request.setTerminal_type("WEB");
        request.setPay_method_id("Coopay");

        PayUnifiedorderResponse response;
        try {
            response = openapiClient.execute(request, EAuthType.BASIC_AUTH);
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
        // Please redirect to the page shown in pay_URL, and the user will complete the remaining payment process
        System.err.println("pay_url:  " + response.getPay_url());
    }

    @Test
    public void payTokenQueryTest() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, TEST_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY, "ub89c59013640b3820b9b0a75763ba6f3", "pb53f5de5ba9951aa24fe47e753ce3345");

        //  Instantiate the request class corresponding to the specific API.
        PayTokenQueryRequest request = new PayTokenQueryRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100085224");
        request.setMerchant_order_no("L2174546467210125318");

        PayTokenResponse response;
        try {
            response = openapiClient.execute(request, EAuthType.RSA2);
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
        // Please redirect to the page shown in pay_URL, and the user will complete the remaining payment process
        System.err.println("token:  " + response.getToken());
    }

    @Test
    public void tokenPayTest() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, TEST_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY, "ub89c59013640b3820b9b0a75763ba6f3", "pb53f5de5ba9951aa24fe47e753ce3345");

        //  Instantiate the request class corresponding to the specific API.
        PayTokenSubmitRequest request = new PayTokenSubmitRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("302100085224");
        request.setMerchant_order_no("L2174546467210125318" + System.currentTimeMillis());
        request.setToken("9ec05e72-325e-40fa-a517-3d4e75229915");
        request.setPay_method_id("Visa");
        request.setPrice_currency("ZAR");
        request.setOrder_amount(11.0);

        PayTokenSubmitResponse response;
        try {
            response = openapiClient.execute(request, EAuthType.RSA2);
        } catch (OpenApiException e) {
            // The call failed with an error message printed
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
