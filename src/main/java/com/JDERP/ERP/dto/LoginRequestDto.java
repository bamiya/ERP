package com.JDERP.ERP.dto;

public class LoginRequestDto {
    private String userId;
    private String password;

    // getter/setter
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
