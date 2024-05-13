package com.pclothstore.repository;

import com.pclothstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    void deleteByEmail(String email);
    Customer findCustomerByEmail(String email);
    Optional<Customer> findById(Long id);
}
