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
public class ReconcileTransSummarizeResponse extends OpenApiResponse {

    @Getter
    @Setter
    @ToString
    static class Summary {

        private String pay_method_id;
        private Integer trans_type;
        private Long total_num;
        private BigDecimal total_order_amount;
        private BigDecimal total_tip_amount;
        private BigDecimal total_vat_amount;
        private BigDecimal total_receivable_amount;
        private BigDecimal total_trans_amount;
        private BigDecimal total_trans_fee_m;
        private BigDecimal total_cashback_amount;

    }

    private Integer total;
    private List<Summary> list;

}
