package com.pclothstore.service.impl;

import com.pclothstore.model.Purchases;
import com.pclothstore.repository.PurchasesRepository;
import com.pclothstore.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasesServiceImpl implements PurchasesService {

    @Autowired
    private PurchasesRepository purchasesRepository;

    @Override
    public List<Purchases> getAllPurchases() {
        return purchasesRepository.findAll();
    }

    @Override
    public Purchases placePurchase(Purchases purchase) {
        return purchasesRepository.save(purchase);
    }

    @Override
    public void cancelPurchase(Long id) {
        purchasesRepository.deleteById(id);
    }
}
