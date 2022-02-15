package com.example.digitalDen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Product {
    int productNo;


    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    String productName;
    String productUrl;


}
