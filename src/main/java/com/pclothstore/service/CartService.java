package com.pclothstore.service;

import com.pclothstore.model.Cart;
import com.pclothstore.model.Product;

import java.util.List;

public interface CartService {
    List<Cart> getAllCartItems();
    Cart addToCart(Cart cart);
    void removeFromCart(Long id);
    void removeFromCartByProductId(Long userId, Long productId);
    List<Cart> getCartItemsByUserId(Long userId);
    void removeAllFromCartByUserId(Long userId);

}

