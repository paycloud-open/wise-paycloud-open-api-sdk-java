package com.wiseasy.openapi.request;

import com.wiseasy.openapi.response.DebicheckOrderCreateResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: liqie
 * @Date: 2024/2/29 16:40
 * @Description: The merchant calls this API and requests the POS APP to perform Debicheck TT3 authentication
 */
@Getter
@Setter
@ToString
public class DebicheckOrderCreateRequest extends OpenApiRequest<DebicheckOrderCreateResponse> {

    // Specifies merchant NO assigned by payment gateway
    private String merchant_no;

    // You can get the terminal sn from the merchant platform if you have already added the terminal
    private String terminal_sn;

    // APP that processes messages on the terminal. Value range: WISECASHIER
    private String message_receiving_application;

    // Contract reference number
    private String contract_reference_number;

    // Creditor name
    private String creditor_name;

    // Debtor identification number
    private String debtor_identification_number;

    // Maximum amount
    private Double maximum_amount;

    // Installment amount
    private Double installment_amount;

    // Bank card number to be verified
    private String account_no;

    /**
     * The following parameters are optional input
     */
    // Order queue mode
    private String order_queue_mode;

    // Specify the callback address for receiving gateway debicheck authentication structure notifications
    private String notify_url;
}
