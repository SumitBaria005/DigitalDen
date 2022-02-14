package com.example.digitalDen.services;

import com.example.digitalDen.entities.Product;

import java.sql.SQLException;
import java.util.List;


public interface ProductService {
    List<Product> getProducts() throws SQLException;
}
