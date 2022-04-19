package com.example.digitalDen.DTO.response;

public class DealerAccount {
    private String bankName;
    private String IFSCcode;
    private String accountNo;
    private String createdDate;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIFSCcode() {
        return IFSCcode;
    }

    public void setIFSCcode(String IFSCcode) {
        this.IFSCcode = IFSCcode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
