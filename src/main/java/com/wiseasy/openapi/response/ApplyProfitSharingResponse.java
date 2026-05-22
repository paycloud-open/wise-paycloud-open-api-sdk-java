package com.wiseasy.openapi.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2025 Wiseasy. All rights reserved.
 * PayCloud
 *
 * @author develop
 * @date 2025/9/2 15:07
 * @project wise-paycloud-pps
 * @description 申请分账响应结构
 * @since 2.4.5
 */
@Data
public class ApplyProfitSharingResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分账交易号
     */
    private String sharing_trans_no;
    /**
     * 原订单交易号
     */
    private String trans_no;


    /**
     * 分账详情列表
     */
    private List<ProfitSharingDetailResult> receivers;

    /**
     * 分账结果详情
     */
    @Data
    public static class ProfitSharingDetailResult implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 分账方商户号
         */
        private String sub_merchant_no;

        /**
         * 分账金额
         */
        private BigDecimal sharing_amount;

        /**
         * 结算币种
         */
        private String settlement_currency;

        /**
         * 实际结算金额
         */
        private BigDecimal actual_settlement_amount;

        /**
         * 分账手续费
         */
        private BigDecimal settlement_fee;

        /**
         * 手续费承担方，0：商户承担，1：分账方承担
         */
        private Integer fee_bearer;

        /**
         * 分账状态：0-待分账 1-分账成功 2-分账失败
         */
        private Integer status;

        /**
         * 失败原因
         */
        private String fail_reason;

        /**
         * 分账创建时间
         */
        private Date create_time;

        /**
         * 分账完成时间
         */
        private Date finish_time;

        /**
         * 分账子订单号
         */
        private String sub_sharing_trans_no;
    }
}
