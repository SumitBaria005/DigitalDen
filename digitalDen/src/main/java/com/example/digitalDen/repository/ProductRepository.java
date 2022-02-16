package com.example.digitalDen.repository;

import com.example.digitalDen.entities.Categories.Mobiles;
import com.example.digitalDen.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    List<Product> getProducts() throws SQLException;

    Product getProduct(Integer product_id) throws SQLException;

    void setProduct(Mobiles mobile);
}
