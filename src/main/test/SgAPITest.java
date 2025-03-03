import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.request.PayUnifiedorderRequest;
import com.wiseasy.openapi.response.PayUnifiedorderResponse;
import com.wiseasy.openapi.utils.EAuthType;
import org.junit.Test;

public class SgAPITest {

    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCKIxPawWYj19KIYWU4TOd9vPjxzku+N+ncHRzS+niZY0UQ2k4CJ8nz1ptsJ0OH6dn5quLBHLkaMa4Rq5h5LMqWWf9y68ztF5W6cKF0kO9RCCYAO1Qey+A7o+/e91DpngyWIXTW8F4xc/diTBekz4gph+ppf3wR9SLaqWxPC6sHoalZHlzWYiEvYM7XGFO1R5IFe0lN/Y8zzPUvrmf+szb6uX2e2z7+c6LDWtZ27/bwjPcHzrIGiE0/1kaoMUgAJ4qFivypqC1iVxPW9N7lGVP8bMWFDHS67kMZGzBzMddhcSjMHVRNMaXgG/9ayl7g1jw2ZilpIimaROiVqGbLBZitAgMBAAECggEAbMT6GUI3vvluGV03aoGDtgpaq2wZUAqO5nc1/xqiY4U7GO4Mhr310z6k2yB/mEGXFXRtYEnRpsJ/ogJP6PpP+tuavU7W6cmsaEXPnA2To2abJYuRzT4TrmKDujlbSNjeaEiny6cxRBdgL9Jiu69+M9WFytRLSYiQjUTit8skPLjkdEgqUVkr95lFSHMNRGSkm0Zwk1f3EJK9NCEK/9WSQSPuJ4BFFcnDEldpgpEvvOEhPaZVySnQzHtruyc7eIb69rM57xAvhGpa8WfSqUTKnpDUgyYpuSMrgYRnFWhW9/fb1ztq7qC+6C3Y18nMlPd/u95+D6hLiq5Xz0eGNC5ssQKBgQD/uQT31PMGG6v4KsSs3mHoH+XHCTnk44AuuZwLa/r1Koj7mfPUdiVsS+xzMVnbfFKc7+g50hb+2Y2KUh+ky2MXU1/0go1q5vRdqKMqu4I9yJIS330TdUTZyO+sptmY4mB7pL3VgCr1YlNTXP9ijP/1PjtKxDE87G4FS4EykGxhGwKBgQCKSWuIjrjCDjk1rMgQhzx0LlrF5+8hWgi5K/cZ4AHOaQhUFZ60+Ymt4jxsOzHi8xUnozkZsXA0gye8KikZaiJP2LP87gtPB6tXfUMtlDYsCJQZebZyhP9esYrHtpljYj0MFtjd5neNGx5e2hTcYr0xEL4PAwv5nz7BfP7LorvR1wKBgBlh2v1idLDRhFNAo37pH9yzddI4tzdh4XJB2BxGHoXBMBGRKWOYSoSiUJjqeBnSED0lju5WTRQEsgjdt+hai75f9zFE2BaZT/4P5Ao0zGungeA/sKGCzU+0ox2G/igvqBX9tx3+98SdetnWbD7y8eD8yVPVf3GlohICeZN0RF2rAoGAScr8Exb2CLfGV5on+Inx/J1v2wP1W3rMBOQtLCWZUShDRXt0AWbXzW5Yh/jemhjVRR2Yrtk84wjJ/2MQI3u7a5hcE7CDYFzbVgiF/KCGd+DsBtwoO9w02bcsM36BQ8N8iCL4/xCo4yeBgWQmlaQrCS/B/AjILyCHQIEPBmOEjmkCgYEA7xayYmWgzGEgVMTuyE1d8/iNW61+JO17vOXueoo3sPoxxa3QjfFwzXNI5U3DQahOs78tvdgyXGZUwh1sAL6ZbuHU6rTsgerHXG1ApAwMQ2IsWYCUd1mSxIfirpxfLEMVEiDX66j43YJwQDSFQ9rgk75BegZi97azQx9jhwzLgVg=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz4fa3596f449b1ecc";

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
        System.err.println("pay_url:  " + response.getPay_url());
    }

    @Test
    public void basicAuthTest() {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, TEST_URL, null, GATEWAY_RSA_PUBLIC_KEY, "ub89c59013640b3820b9b0a75763ba6f3", "pb53f5de5ba9951aa24fe47e753ce3345");

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

}
