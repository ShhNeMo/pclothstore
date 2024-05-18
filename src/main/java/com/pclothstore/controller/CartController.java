package com.pclothstore.controller;

import com.pclothstore.model.Cart;
import com.pclothstore.model.Product;
import com.pclothstore.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/user/{userId}")
    public List<Cart> getCartItemsByUserId(@PathVariable Long userId) {
        return cartService.getCartItemsByUserId(userId);
    }

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }

    @GetMapping("/all")
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @DeleteMapping("/user/{userId}/product/{productId}")
    public void removeFromCartByProductId(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.removeFromCartByProductId(userId, productId);
    }

}
