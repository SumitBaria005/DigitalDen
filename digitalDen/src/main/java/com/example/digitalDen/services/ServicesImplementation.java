package com.example.digitalDen.services;

import com.example.digitalDen.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImplementation implements Services{
    @Override
    public List<Product> getProducts(int pageNo) {
        return null;
    }
}
