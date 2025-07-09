package com.JDERP.ERP.model;

import lombok.Data;

@Data
public class Login {
    private String userId;
    private String password;
    private String passwordType;
    private String userName;
    private String empNo;
}
