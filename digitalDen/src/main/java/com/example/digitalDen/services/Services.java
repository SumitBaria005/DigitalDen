package com.example.digitalDen.services;

import com.example.digitalDen.entities.Product;

import java.util.List;


public interface Services {
    List<Product> getProducts(int pageNo);
}
