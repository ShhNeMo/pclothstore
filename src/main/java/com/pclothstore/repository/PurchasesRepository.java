package com.pclothstore.repository;

import com.pclothstore.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
    List<Purchases> findByUserId(Long userId);
}
