package com.pclothstore.service;

import com.pclothstore.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCartItems();
    Cart addToCart(Cart cart);
    void removeFromCart(Long id);
    List<Cart> getCartItemsByUserId(Long userId);
}
