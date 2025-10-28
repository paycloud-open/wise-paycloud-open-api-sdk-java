package com.wiseasy.openapi.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (c) 2025 Wiseasy. All rights reserved.
 * PayCloud
 *
 * @author develop
 * @date 2025/9/2 11:32
 * @project wise-paycloud-pps
 * @description 分账请求参数
 * @since 2.4.5
 */
@Data
@SuppressWarnings("all")
public class RefundProfitSharingRequest extends ApplyProfitSharingRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 退款交易号
     */
    private String refund_trans_no;

    /**
     * 分账退还请求号
     */
    private String sharing_refund_trans_no;

}
