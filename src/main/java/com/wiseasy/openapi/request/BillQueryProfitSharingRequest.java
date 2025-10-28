package com.wiseasy.openapi.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class BillQueryProfitSharingRequest implements Serializable {

    private String institution_no;

    private String merchant_no;

    private String bill_date;

    private Integer page_size = 50;

    private Integer page_num = 1;

}
