package com.example.digitalDen.repository;

import com.example.digitalDen.entities.Cart;
import com.example.digitalDen.entities.CartToProductMapping;

public interface CartRepository {
    public Cart addCart(CartToProductMapping cart,int customerId);

    Cart getCart(Integer customerId);
}
