package com.wiseasy.openapi.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultQueryProfitSharingRequest implements Serializable {

    private String  sharing_trans_no;
    private String  trans_no;
    private String  merchant_no;

}
