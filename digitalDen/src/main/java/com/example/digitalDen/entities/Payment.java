package com.example.digitalDen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Payment")
@Table(name = "payment", schema = "payment")
public class Payment {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "provider")
    private String provider;

    @Column(name = "status")
    private String status;

    @Column(name = "crated_date")
    private String createdDate;

    @Column(name = "updated_date")
    private String updatedDate;

}
