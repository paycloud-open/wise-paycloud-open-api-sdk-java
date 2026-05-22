package com.wiseasy.openapi.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

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
public class ApplyProfitSharingRequest {
    private static final long serialVersionUID = 1L;

    private String sharing_trans_no;
    private String trans_no;
    private String institution_no;
    private String merchant_no;

    private BigDecimal sharing_amount;

    @JSONField(defaultValue = "false")
    private Boolean unfreeze_unsplit;

    //币种
    private String price_currency;

    private String receivers;
}
