package com.pclothstore.service;

import com.pclothstore.model.Product;
import com.pclothstore.model.Purchases;

import java.util.List;

public interface PurchasesService {
    List<Purchases> getAllPurchases();
    Purchases placePurchase(Purchases purchase);
    List<Purchases> placePurchases(List<Purchases> purchases);
    void cancelPurchase(Long id);
    List<Purchases> getPurchasesByUserId(Long userId);

}
