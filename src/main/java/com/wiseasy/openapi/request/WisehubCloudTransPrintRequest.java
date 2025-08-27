package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.WisehubCloudPayCloseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2023/5/29 16:40
 * @Description: The merchant backend calls this API and the payment gateway will close the order and push a message to the designated application of
 * the IoT device (e.g. smart POS) to remove the order in the queue.
 */
@Getter
@Setter
@ToString
public class WisehubCloudTransPrintRequest extends OpenApiRequest<WisehubCloudPayCloseResponse> {

    // The unique identifier of the merchant in the system, which will be assigned after the merchant has successfully settled in.
    // You can log in to the merchant platform to get it
    private String merchant_no;

    // The serial numbers of POS and other devices, need to be bound on the merchant platform in advance
    private String terminal_sn;

    // Merchant requests a serial number, and a request serial number can only request payment once. If the business order needs to
    // support cancellation and then pay, you should maintain the correspondence between a business order and the payment request serial number
    private String merchant_order_no;
    /**
     * The following parameters are optional input
     */
    // Merchant store identification code, which can be added through the merchant platform, used to record merchant transaction data in a more detailed dimension,
    // and facilitate merchants to conduct reconciliation and management
    private String store_no;


}
