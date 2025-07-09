package com.JDERP.ERP.model;

import lombok.Data;

@Data
public class Employee {
    private String empCd;
    private String empNm;
    private String deptCd;
    private String ynOut;
    private String deptPosition;
    private String tpWeekly;
}