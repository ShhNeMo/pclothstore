package com.pclothstore.controller;

import com.pclothstore.model.Purchases;
import com.pclothstore.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchasesController {

    @Autowired
    private PurchasesService purchasesService;

    @GetMapping
    public List<Purchases> getAllPurchases() {
        return purchasesService.getAllPurchases();
    }

    @PostMapping
    public Purchases placePurchase(@RequestBody Purchases purchase) {
        return purchasesService.placePurchase(purchase);
    }

    @PostMapping("/many")
    public List<Purchases> placePurchases(@RequestBody List<Purchases> purchases) {
        return purchasesService.placePurchases(purchases);
    }

    @DeleteMapping("/{id}")
    public void cancelPurchase(@PathVariable Long id) {
        purchasesService.cancelPurchase(id);
    }
}
