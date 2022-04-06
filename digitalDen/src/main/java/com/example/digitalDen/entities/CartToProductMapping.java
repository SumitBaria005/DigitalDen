package com.example.digitalDen.entities;

import javax.persistence.*;

@Entity(name = "CartToProductMapping")
@Table(name = "CartToProductMapping",schema = "digitalden")
public class CartToProductMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cart_id")
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
