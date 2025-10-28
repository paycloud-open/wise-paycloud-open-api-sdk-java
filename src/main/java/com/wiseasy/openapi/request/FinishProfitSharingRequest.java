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
 * @description 分账完结请求参数
 * @since 2.4.5
 */
@Data
@SuppressWarnings("all")
public class FinishProfitSharingRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trans_no;
    private String institution_no;
    private String merchant_no;
}
