package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Cart;
import com.example.digitalDen.entities.CartToProductMapping;
import com.example.digitalDen.repository.CartRepository;
import com.example.digitalDen.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CartServiceImplementation implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart addCart(CartToProductMapping cart,int customerId) {
        return cartRepository.addCart(cart,customerId);
    }

    @Override
    public Cart getCart(Integer customerId) {
        return cartRepository.getCart(customerId);
    }
}
