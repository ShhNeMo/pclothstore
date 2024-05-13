package com.pclothstore.repository;

import com.pclothstore.model.CustomerPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerPreferencesRepository extends JpaRepository<CustomerPreferences, Long> {
    List<CustomerPreferences> findByCustomerId(Long customerId);
    void deleteByIdAndCustomerId(Long id, Long customerId);
}
