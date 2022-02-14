package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Product;
import com.example.digitalDen.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceImplementation implements ProductService{

    @Override
    public List<Product> getProducts(int pageNo) {
        return null;
    }

}

