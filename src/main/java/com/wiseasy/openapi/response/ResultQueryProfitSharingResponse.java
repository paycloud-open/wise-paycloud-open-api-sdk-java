package com.wiseasy.openapi.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ResultQueryProfitSharingResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trans_no;

    private List<Receivers> receivers;

    @Data
    public static class Receivers implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 分账交易号
         */
        private String sharing_trans_no;

        /**
         * 分账商户号
         */
        private String sub_merchant_no;

        /**
         * 分账金额
         */
        private BigDecimal sharing_amount;

        /**
         * 分账手续费
         */
        private BigDecimal settlement_fee;

        /**
         * 结算币种
         */
        private String settlement_currency;

        /**
         * 实际结算金额
         */
        private BigDecimal actual_settlement_amount;

        /**
         * 手续费承担方，0：商户承担，1：分账方承担
         */
        private Integer fee_bearer;

        /**
         * 分账状态
         */
        private Integer status;

        /**
         * 失败原因
         */
        private String fail_reason;

        /**
         * 请求受理时间
         */
        private Date create_time;

        /**
         * 分账结果时间
         */
        private Date finish_time;

        /**
         * 分账子订单号
         */
        private String sub_sharing_trans_no;

    }

}
