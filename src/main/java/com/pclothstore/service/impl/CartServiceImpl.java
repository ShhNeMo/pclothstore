package com.pclothstore.service.impl;

import com.pclothstore.model.Cart;
import com.pclothstore.repository.CartRepository;
import com.pclothstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getCartItemsByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}
