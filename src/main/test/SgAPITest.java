import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.request.PayUnifiedorderRequest;
import com.wiseasy.openapi.response.PayUnifiedorderResponse;

public class SgAPITest {

    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCM9ATSJMVQIp8Z3/zHnA/fpXrTU+hfurjBocJujQGUrVlVokADZZrjH7674XLSue9f0p/2+ZW1Xl8izI60ybhMAEC5U5sRaTrM4RyRmKFMCDJYzkEGSTO6tVsGJsLgAWxIHSMqYTxLo+qHAyewthNhoeRg0x2y2Y6gMPVuVW3y/FJHQjvMdtrTOG9pDkFZPgcEMrvwoudrDoh38ZgGdpUOB3nFlPvzpki/UV7H6ZTHzZRQRLFYqbZwDyo2YTY7WMZBFCjUmrc5zarPg+OT1mfnNpaYZAiW2DRxZOGWtVFp5q7kEyjB5/M5ShVoMY42iknNietFj2YMaiXiLEScSw21AgMBAAECggEAKe3ArV5Az5is6T6G7D3RPv7zrX9tRWS+5uKeetI5ISf7xgxwrFICJAPicfMbe/HRchiuewI9dWkwNaLR5JeI2hrNJhPnseMymZVxMSJNANgDWgVotFz8JVMjU44eNBJYSo9YUZgBHqMQ9b6LhPZ0h3tn+yFx2Sz8T0yhBYQmI7xWugBskVikL53X+dOBpDMIBkOQdAaeAYHXEZGHQ3kQkbPJG1BXpTJOzAt2z8m4s6jNYcLHVnj/8MmowfNtEDMfGJ6QaQA9TvQexebF7En1zdRqZ6JImVpDAk9JhvZRtWKt70seGaBEHtfnY23zXQ9ML50+PkKqYSmkWUDtQukmdQKBgQDeLhOsIMOWQCG85P1juGx2YslE7PqEIV8WXQn9IXonrO/TYO7kXL2OPyJ8gfUtKcrM9s9c60dosHQx9XquTjuAT9yik82G5QVlitjZYuz4Si8/w/s4qlm4brgQPzL7wf3YNPH1yN64f9V9/SUoFdUY2FfG9R+r1L7q8+rmB+KuvwKBgQCiaLEKy5t0DhDBCzJRn4yU9cZLsthbaEH10pFzddlnoXVsz1ZAsoaBIys1fBbUTWBaj2M4VeZ7Dh/Qj9hZQvP4dMy5lxSe2A2RyR5+sYzezRm4ZYssqes44zHedP3UBl96aK2YwkyBedUoc7X4OsCL/Kzbt1zmxm9eqb6LxIDUiwKBgQCaYyJAZbQDYCURgX2iIbEcwqBhSNr7ncTZYWVjhDPCBiXQmHboMJl3kt9/7T5VV8kYjBij1MoWMSdM3+uT28D09Im4X0ReDB6n5Meyp09LaSFUCfcz9QvLYQR+JaxjzPV7m67Wv/Ij+pB7r8B2DlW5ofu8wPB1Eqxnz37WwXv/OQKBgFJKh8J3jmoMonKeML3pAPuNWQ+MLFKMjjd3nVmKkkEPL4eVuxeHHd4bKs6r9IlYN4VLeDPYWrNpYbd022PHKAVxcTZslfcydBW1eW0qm71c4TZsxUs5QcWOYPtd/itLm19T4PoxIUDNsbMQhlijtGJ6AkBGNZ19WHr3uWPqininAoGAPFPiEa1LIe4h0pxHQx+TfbZt1UP53OB8IJrqOygOOhPoepPllfbd1DPRVeem/j7pWmIYIrPiXpb8OO5NsH0mEzq3IfMyXLknaXzF/2rkQ8ZwfeAVi5ku0hhfb3mIR4uTIneyJM+gs7iqk9e3p6kQRUgixqH1jThAbrEtEIeQrtI=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wzabed8b0306fa1afa";

    private static final String TEST_URL = "https://wiseasy-open.sg.wisepaycloud.com";

    private static final String PROD_URL = "https://wiseasy-open.sg.paycloud.world";

    /**
     Create an order through online payment and receive the payment page URL "pay_url" hosted on Wiseasy PayCloud.
     Redirect the user's request to this page and enter account and other information for secure payment.
     For more information, please refer to the document: https://gw.paycloud.world/docs/#/unifiedOrder
     Please refer to the documentation for Java SDK: https://gw.paycloud.world/docs/#/javaSDK
     For other development languages and API usage methods, please browse: https://gw.paycloud.world/docs/#/?id=readme
     */
    public static void main(String[] args) {
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
        // Please redirect to the page shown in pay_URL, and the user will complete the remaining payment process
        System.err.println("pay_url:  " + response.getPay_url());
    }

}
