package com.JDERP.ERP.dto;

public class LoginRequestDto {
    private String emp_cd;
    private String password;

    // getter/setter
    public String getEmp_cd() { return emp_cd; }
    public void setEmp_cd(String emp_cd) { this.emp_cd = emp_cd; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
