package com.pclothstore.service;

import com.pclothstore.model.Purchases;

import java.util.List;

public interface PurchasesService {
    List<Purchases> getAllPurchases();
    Purchases placePurchase(Purchases purchase);
    void cancelPurchase(Long id);
}
