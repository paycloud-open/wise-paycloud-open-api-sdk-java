package com.wiseasy.openapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangyuxiang
 * @since 2023-12-14 09:28
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ReconcileTransDetailsResponse extends OpenApiResponse {

    @Getter
    @Setter
    @ToString
    static class Trans {

        private String trans_no;
        private String merchant_order_no;
        private Integer trans_type;
        private String trans_end_time;
        private String price_currency;
        private BigDecimal order_amount;
        private BigDecimal tip_amount;
        private BigDecimal trans_amount;
        private BigDecimal trans_fee_m;
        private BigDecimal cashback_amount;
        private BigDecimal receivable_amount;
        private BigDecimal vat_amount;
        private String merchant_no;
        private String store_no;
        private String out_store_no;
        private String store_name;
        private String terminal_sn;
        private String tid;
        private String pay_scenario;
        private String ref_no;
        private String pay_method_id;

    }

    private Integer total;
    private List<Trans> list;

}
