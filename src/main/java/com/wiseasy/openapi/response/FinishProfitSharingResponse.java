package com.wiseasy.openapi.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (c) 2025 Wiseasy. All rights reserved.
 * PayCloud
 *
 * @author develop
 * @date 2025/9/2 15:07
 * @project wise-paycloud-pps
 * @description 完结分账响应结构
 * @since 2.4.5
 */
@Data
@SuppressWarnings("all")
public class FinishProfitSharingResponse implements Serializable {

    private String trans_no;
    private String settlement_date;
    private Integer sharing_record_count=0;

}
