package com.pclothstore.service.impl;

import com.pclothstore.model.Cart;
import com.pclothstore.model.Product;
import com.pclothstore.repository.CartRepository;
import com.pclothstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public void removeFromCartByProductId(Long userId, Long productId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        for (Cart cart : cartItems) {
            if (cart.getProduct().getId().equals(productId)) {
                cartRepository.deleteById(cart.getId());
                break;
            }
        }
    }
}
