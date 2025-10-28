package com.wiseasy.openapi.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class RefundQueryProfitSharingResponse implements Serializable {


    private static final long serialVersionUID = 1L;

    private String trans_no;

    private List<RefundQueryProfitSharingResponse.Receivers> receivers;

    @Data
    public static class Receivers implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 分账交易号
         */
        private String sharing_trans_no;

        /**
         * 分账退款交易号
         */
        private String sharing_refund_trans_no;

        /**
         * 分账商户号
         */
        private String sub_merchant_no;

        /**
         * 分账退还金额
         */
        private BigDecimal sharing_amount;

        /**
         * 剩余可退金额
         */
        private BigDecimal left_amount;


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
