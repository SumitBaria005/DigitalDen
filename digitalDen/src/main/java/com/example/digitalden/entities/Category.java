package com.example.digitalden.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Category")
@Table(name = "categoryData")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    public Category(Long id, String categoryName, Long productId) {
        this.id = id;
        this.categoryName = categoryName;
        this.productId = productId;
    }

    public Category() {
    }

    @Column(name = "product_id")
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
