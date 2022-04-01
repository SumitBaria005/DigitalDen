package com.example.digitalDen.entities;

import javax.persistence.*;

@Entity(name = "Customer")
@Table(name = "customer", schema = "digitalden")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer Id;

    @Column(name = "customer_name")
    String customerName;

    @Column(name = "email")
    String email;

    @Column(name = "contact")
    String contact;

    @Column(name = "address")
    String address;

    @Column(name = "dob")
    String dob;

    @Column(name = "password")
    String password;

    public Customer(Integer id, String customerName, String email, String contact, String address, String dob, String password) {
        Id = id;
        this.customerName = customerName;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.dob = dob;
        this.password = password;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
