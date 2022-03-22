package com.example.digitalden.entities.complaints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Complaints")
@Table(name = "complaints")
public class Complaints {
    @Id
    @Column(name = "complaint_id")
    Long complaintId;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "customer_id")
    Long customerId;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "complaint")
    String complaint;

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
