package com.example.digitalDen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Order")
@Table(name = "order", schema = "Order")
public class Order {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_date")
    private String updatedDate;

}
