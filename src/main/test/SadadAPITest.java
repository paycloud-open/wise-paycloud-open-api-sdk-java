import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wiseasy.openapi.OpenApiClient;
import com.wiseasy.openapi.OpenApiException;
import com.wiseasy.openapi.request.*;
import com.wiseasy.openapi.response.*;
import org.junit.Before;
import org.junit.Test;

public class SadadAPITest {
    private static final String APP_RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDKZdWnnYDi7hfKFgzzqvF9WD962M54PMRuyIVXIuLMzb/PTtAW1CUCSTIH2kJ+zyQLMA9Xgiz3B7Aht0HyBfVB6v3ouaULXkI3k60yWIlKbgHDkAUdTPMUOgKW/ptF0jzO+TFtihIFo4EwSkQl3rb82R/qObJ+48uPVnzi1OdR+m9sNvoDfANY3u9JxSJw4ond2YVw4Arn9REnEgY4JDjkVEfjmIFzakFZsohLxNFNjutfmvypqiZh4GcKQRTNra+z5X8fCIqdB1y99IJ0+xU5OjmA6XB12rhUJjnIXKE/woOm4iwfbTRW6gpYgnMf177DSrUi7+KckwHgRLXWx3CtAgMBAAECggEAbxR0rglDM0h4xfBUK2cmIiTMsh9LMbIoHKTwiWIcF0rUenJGwkCsDxUc4DJpTC9jGMDHqr9G7kzJ3bc1+h5K/GJ7973rVtHkhZwG8hqlPrQhQ7NHG02gGvm7ciNKFIfN18nr1rJwMagKvvYDcMVKqHqBiYsg64MZtRFCeTtfuR0+bDNBwl15soyQQizg9M+TiFrrzlsu05h97RDn2kHM7ySQUGELH+d6VN6KIR/zMWXCPP40KJFn0Icnd+8rg3+rwk82zlAwZyi/bEUYRNo4hIILi5xoAc38/IDv0iRJSMuQBs+VnTsJV/xeeWz4Gomttjqg5ci6QDq0SSfPxgBgAQKBgQD2FBA48LVxe5KW8G4dNA5B/CLr6PDreMcTr4ABdR+ajPuwR5pFOzSLOgNYusf6XguiiiIQOQhs4tUPqlXi7BpryqRZpnq0ViGcJfo9iJybg9Tpu7AK9X9Lvd6DDwXhkoNxcz60dnwPBDwDuOT4RPaU+rFr4k9zocyqbM+qE+j8UQKBgQDSjupMiPzN4OXVgs/wC0m+md3bvhc6bqwLF850DlZVHDtxbLlBrdQLVM18GG6S8LOoPrGDZTRIvgbX1jEXjl0tk6c7ICJYKRwjvx6tnwcI+jelT2quKz8w1vpqhFsb01yAwuaudVmj0i8BOt1a6lq6Ls2BgXgevrmrPQ0Cx8PDnQKBgF9qwC+UBocOZ3TnnYrtWGn1noTjOifUGT1k27m09KA08pMT8JnPrzwdLpcFNe268cAA19x6gO3Xts3wOoVXD5ekZ73rc8DhdP7bKwEZK8CRicln4YceUlHIObOP67Pf39/p0/KdztTzy2GWHBK4ivSRkKJIio5HutiKgKtuNPVBAoGADIYHlYnIT46C3RIswABL4JRSR9GknAsdHIPL+ccoh2NofbSTyD5IkGv41Nq3KPI8HVOtRz1rwK/cxFWvEdGb5SwVFEUzBb9cNxwU/QqqZnRLfv+cPsO/vG3s8wzwRlVp+Raeld3Q+Rd1SENyCwhJYS2Ld5p1xI5fiLnW3kV3dVkCgYASYlU26SpywOCue6qs4ztzRvqnQgWWrOl7R+PtaJvidOGlinNWutr0DQU/73MBnkJdKaXBBLHpxrAxwF6x3t2w707H4K3sWhoKAFMVLr6h3Xdz9MYlRk0pFXLatfn0thYeUZjPm8wacaC5N7gNCRqcO7eJaJpledkM8CRFQzY1aw==";
    private static final String GATEWAY_RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAplNGveqcnfEfoIX5Db2DDZ6aLOC5jkGFItwi0NcZBBxj6scwg91/wZbp6DzPk/GKO6o7Za2pbKFPqpE4EDXbNT6TvRApyQomDd9FMlnDkNvjv5Rlvp/uewaQfAAGkeFex0Fm03bWAuC1iDJxcJTT1vIc1g7EBMOqpvW3R5jiXyCLcYZm85YcbSN2ez3R5ckL+pHVXQR6iJHpceRZjxtBuKqRQ7CbrvkwkvQ53FIyQ6H0l7T0F6HZ6/Js+2vo2DWLRvGlgntRP87P6Bi18OhhKy7r5dC1E6ZYc2zem6ntzqj/zOXG10HVKBVJmhjxMYq2Ud6u/MH3JLDwGk+nr3kOGQIDAQAB";
    private static final String APP_ID = "wzaf502bde7e10f150";
    private static final String SANDBOX_GATEWAY_URL = "https://open-uat.sadadpos.com/";

    private static final String GATEWAY_URL = "https://open.sadadpos.com/";

    @Before
    public void init() {
        // 设置全局 SOCKS 代理
        //System.setProperty("socksProxyHost", "127.0.0.1");
        //System.setProperty("socksProxyPort", "10808");
    }

    @Test
    public void MerchantOnboarding() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        MerchantOnboardingQatarRequest request = new MerchantOnboardingQatarRequest();
        request.setInstitution_no("100013888");
        request.setOut_merchant_no("SADAD-M-0091-015");
        request.setMerchant_name("Avita0915");
        request.setLegal_name("ChangAn Avita lnc.");
        request.setBusiness_type("Car");
        request.setBusiness_nature("Car Nature");
        request.setPayment_facilitator_id("10001388818");
        request.setMcc("0742");
        request.setContact_name("zhangsan");
        request.setContact_email("zhangsan@qq.com");
        request.setContact_phone("974 1234567");
        request.setRegistration_certificate_number("HM9017191001");
        request.setAddress_detail("china beijing changan no.12");
        request.setMdr_plan_id("100012");
        request.setRisk_plan_id("10001");
        request.setOut_store_no("SADAD-S-0091");
        request.setStore_name("Avita Beijing 0091");
        request.setStore_address_detail("china beijing changan no.12-A");
        request.setPay_channel_id("PC0122QAT");
        request.setMid("178989761718171");
        request.setAmex_mid("278989761718171");
        request.setSupport_trans_type_list("[1,3]");

        JSONArray terminal_list = new JSONArray();
        JSONObject terminal1 = new JSONObject();
        terminal1.put("terminal_sn", "P11111155");
        terminal1.put("tid", "T1111115-115");
        terminal_list.add(terminal1);
        JSONObject terminal2 = new JSONObject();
        terminal2.put("terminal_sn", "P11111255");
        terminal2.put("tid", "T1111125-115");
        terminal_list.add(terminal2);
        JSONObject terminal3 = new JSONObject();
        terminal3.put("terminal_sn", "P11111355");
        terminal3.put("tid", "T1111135-115");
        terminal_list.add(terminal3);
        request.setTerminal_list(terminal_list.toJSONString());

        // Build a response object
        MerchantOnboardingQatarResponse response;
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
    public void ECROrderSale() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        WisehubCloudPayOrderRequest request = new WisehubCloudPayOrderRequest();
        request.setMerchant_no("302400004438");
        request.setStore_no("4024000040");
        request.setTerminal_sn("WPYB002349002550");
        request.setPrice_currency("QAR");
        request.setMessage_receiving_application("SADAD POS");
        request.setPay_scenario("SWIPE_CARD");
        request.setOrder_amount(66.33);
        request.setTrans_type(1);
        request.setOrig_merchant_order_no("TEST_1731578873757");
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
        request.setMerchant_no("302400004438");
        request.setStore_no("4024000040");
        request.setTerminal_sn("WPYB002349002550");
        request.setMessage_receiving_application("SADAD POS");
        request.setMerchant_order_no("TEST_1731578873757");
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
    public void OrderQuery() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderQueryRequest request = new OrderQueryRequest();
        request.setMerchant_no("302400004438");
        request.setMerchant_order_no("TEST_1731578873757001");

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
    public void RefundQuery() {
        // Instantiate a client
        OpenApiClient openapiClient = new OpenApiClient(APP_ID, SANDBOX_GATEWAY_URL, APP_RSA_PRIVATE_KEY, GATEWAY_RSA_PUBLIC_KEY);

        // Build a request object, set parameters
        OrderRefundQueryRequest request = new OrderRefundQueryRequest();
        request.setMerchant_no("302400004438");
        request.setMerchant_order_no("TEST_1731578873757001001");

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

}
