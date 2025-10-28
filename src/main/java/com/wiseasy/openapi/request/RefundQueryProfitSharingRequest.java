package com.wiseasy.openapi.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefundQueryProfitSharingRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String institution_no; // 机构号
    private String merchant_no;// 商户号
    private String trans_no;// 交易号
    private String sharing_trans_no; // 分账交易号
    private String refund_trans_no; // 原退款交易号
    private String sharing_refund_trans_no; //分账退还交易号

}
