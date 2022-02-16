package com.example.digitalDen.services.impl;

import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.entities.Categories.Mobiles;
import com.example.digitalDen.entities.Product;
import com.example.digitalDen.repository.ProductRepository;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.sql.*;

import java.util.List;

import javax.transaction.Transactional;


@Service
@Transactional
public class ProductServiceImplementation implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() throws SQLException {
        return productRepository.getProducts();
    }

    @Override
    public Product getProduct(Integer product_id) throws SQLException {
        return productRepository.getProduct(product_id);
    }

    @Override
    public void setProduct(Mobiles mobile){
        productRepository.setProduct(mobile);
    }
}

