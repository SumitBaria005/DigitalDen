package com.example.digitalDen.api.request;

public class CustomerLogInRequest {
    private String userName;
    private String password;

    public CustomerLogInRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public CustomerLogInRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerLogInRequest{" +
                "UserName='" + userName + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
