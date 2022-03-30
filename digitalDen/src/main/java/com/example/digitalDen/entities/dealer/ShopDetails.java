package com.example.digitalDen.entities.dealer;

import javax.persistence.*;

@Entity(name = "ShopDetails")
@Table(name = "ShopDetails",schema = "digitalden")
public class ShopDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "business_email")
    private String email;

    @Column(name = "shop_contact")
    private String shopContact;

    @Column(name = "address")
    private String address;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "pin_code")
    private String pinCode;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @Column(name = "created_date")
    private String CreatedDate;

    @Column(name = "updated_date")
    private String updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShopContact() {
        return shopContact;
    }

    public void setShopContact(String shopContact) {
        this.shopContact = shopContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
