import com.alibaba.fastjson.JSON;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.request.CscanbPayGetqrcodeRequest;
import com.wiseasy.openapi.response.CscanbPayGetqrcodeResponse;

public class IPPSAPITest {

    private static final String APP_RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCl3KYM/l4+bcL8UdpxmVEKaLJAq0aLEfWKc0FKX82a78vmrfw34HkQLHNLXmNGEzdloi64yyuROy7HokT/pxnvMS1ucRoZqhKY/pWguSQ0Zckr1EuLE3Zgjd8BfSiGHXYOtC0SjdMZnotExwxlsioupQlziufUbZqsOrO1EVjUbsv6TRm0Pb/yYuv+qN3NbcCfCAu314tMZd1nJCilrCDlVyK6WH5zD4X/X2aX52/BXWwE0XViA2Pw+PrGJViMJ+QL1h0AUwcBbMeSOFFKyHOooOtaIcpgI5qD9XaSoCBDkN+fP5yXenw0gl2r5WWPIqI42szGlygXeGGkB7DUhqv1AgMBAAECggEAJ6M5k7VedHDqvj4ZhDhto50trELCUw3xriqpGcsXacWQ5woBUqE0jWbyDrr54o9JF+LQY506RjTskwz2jFo02nLYNqKU6Dk6xJFi1MwqGNOSZgUQIKaADccZ2lM80gBMbGsmsl5uapr3EXK4Rb10Uz1hqtkxWhTvd+V3ePgyUGHffAkcAXXuoqbHq+a/r1vlU/TniaBVRbdwzs2lRPMR2pQORvcrz8CX0Mkg/NLN0ZECMa9rIvlMvRXADXB+2xcMgzAeLi/vnY9QRQnv2h/Ahr5T8c7w2LomtDz9nmT5Hy83j7lHDVSyKcbeozQRZHTSZ4wl8tz3atxHJJAIOlLY6QKBgQDaAPmL8JFsXnGeS8zzXdJzcXWA/n9+o3Y0F68wcMg/CwDQw7JiLZPwe/Avk+KDuF/4N2EdvAyV5YRnVgOLmThhZKv4V3poiQnucbrS/qu3dpB0CeJgJR2RjST4H/1Ofy9jarTZaOlR9nyGCqTyB1Mhu4JAjPZ5bjlbznJUpcLfWwKBgQDCxSzY8YGhiRDxViyitgduQ2fr7+gaKQn3/h2FYzUKMuXAoxnKK5XPF3mEIjIwH6GQIkb5sGr97h+5qqOkjNgs//EkIasurTtLmoVTFFDdsgBWnuMFSZZXL7N3j2Tg7tcgXKwgeIzK8QUErSO9PT1kwxDdk1DQiAmbN3CaWrdS7wKBgCpnviLmbKMzy84K2JcOTP1/uGebGZm8miWP5df6WDlLHqF9L5nBW+GPei0HCyysFJ7nxtBN3/TYbGTdalshNsJbHshz26+x2Gi1Xq3kM+q/+WFY+tvQ3GuPlP1e25sFSmaAPyV7LsduttIsB+G8YwNQwglkYh1Ev4uIIN0uUTW5AoGBAIrBb9bKDuDmxhQ4oSn15ktOaB201zSz4e8zsRJS//lZE0buqzPVYy+a+K4CsqCIGFCXqtq9LSvkVeOuxlA3Kta8K63i8pIZRbHxzmPGiGm4IveS0Ab3SsyoJgHaPTLl1IqwmsuzNhJqLHoNYvWxSCids0k3Zw54q+dRUr4UPKAvAoGAYU2s0VTrLKsc1WX+xOg/GDFdnDCgnGupGHuD+1ZfAdwg+knEO4LH+pV3dMaB4YSeuFJgvWSbXWwxGP2FE8RmTcfTYbyVp40Ti4Mcahz4bQFybyM64ymKfRBLP3Klyt1PLB4p6HPqObbOk9gjHTf4/mURL5E7oNGaOmVusnRYmjQ=";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";
    private static final String APP_ID = "wz15b8ed73e8b24dbf";
    private static final String PROD_URL = "https://ipps-open.sg.paycloud.world";

    public static void main(String[] args) {
        //  Instantiate the client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, PROD_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        //  Instantiate the request class corresponding to the specific API.
        CscanbPayGetqrcodeRequest request = new CscanbPayGetqrcodeRequest();

        //  The SDK already encapsulates the public parameters; here you only need to pass in the business parameters
        request.setMerchant_no("332400025778");
        request.setStore_no("4325000012");
        request.setMerchant_order_no("TEST_" + System.currentTimeMillis());
        request.setPrice_currency("THB");
        request.setTrans_amount(1.05);
        request.setDescription("IPhone 15 5G White");
        request.setExpires(300);
        request.setTerm_ip("127.0.0.1");
        request.setPay_method_id("ThaiQR");
        request.setAttach("{\"key\":\"value\"}");
        request.setNotify_url("https://m.website.com/pay/notify");
        request.setTerm_ip("117.172.47.151");
        request.setDescription("IPhone 15 5G White");
        request.setLatitude("35.41");
        request.setLongitude("139.44");

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
        // Please redirect to the page shown in pay_URL, and the user will complete the remaining payment process
        System.err.println("qrcode_url:  " + response.getQrcode_url());
    }

}
