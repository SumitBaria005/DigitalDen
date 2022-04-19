package com.example.digitalDen.DTO.response;

import java.util.List;

public class DealerData {
    private String name;
    private String dateOfBirth;
    private String email;
    private String contactNo;
    private String address;
    private List<DealerShops> dealerShops;
    private DealerAccount dealerAccount;

    public DealerAccount getDealerAccount() {
        return dealerAccount;
    }

    public void setDealerAccount(DealerAccount dealerAccount) {
        this.dealerAccount = dealerAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<DealerShops> getDealerShops() {
        return dealerShops;
    }

    public void setDealerShops(List<DealerShops> dealerShops) {
        this.dealerShops = dealerShops;
    }
}
