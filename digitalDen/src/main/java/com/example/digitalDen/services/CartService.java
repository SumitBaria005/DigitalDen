package com.example.digitalDen.services;

import com.example.digitalDen.entities.Cart;
import com.example.digitalDen.entities.CartToProductMapping;

public interface CartService {
     Cart addCart(CartToProductMapping cart,int customerId);

     Cart getCart(Integer customerId);
}
