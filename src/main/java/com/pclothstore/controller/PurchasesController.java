package com.pclothstore.controller;

import com.pclothstore.model.Purchases;
import com.pclothstore.service.PurchasesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/purchases")
public class PurchasesController {

    private final PurchasesService purchasesService;

    @GetMapping("/user/{userId}")
    public List<Purchases> getPurchasesByUserId(@PathVariable Long userId) {
        return purchasesService.getPurchasesByUserId(userId);
    }

    @GetMapping
    public List<Purchases> getAllPurchases() {
        return purchasesService.getAllPurchases();
    }

    @PostMapping
    public Purchases placePurchase(@RequestBody Purchases purchase) {
        return purchasesService.placePurchase(purchase);
    }

    @PostMapping("/list")
    public List<Purchases> placePurchases(@RequestBody List<Purchases> purchases) {
        return purchasesService.placePurchases(purchases);
    }

    @DeleteMapping("/{id}")
    public void cancelPurchase(@PathVariable Long id) {
        purchasesService.cancelPurchase(id);
    }
}
