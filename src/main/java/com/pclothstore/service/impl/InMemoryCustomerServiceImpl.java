package com.pclothstore.service.impl;

import com.pclothstore.model.Customer;

import com.pclothstore.repository.InMemoryCustomerDAO;

import com.pclothstore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.pclothstore.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class InMemoryCustomerServiceImpl implements CustomerService {
    private final InMemoryCustomerDAO repository;

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAllCustomers();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.createCustomer(customer);
    }


    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.updateCustomer(customer);
    }

//    @Override
//    public Customer findByEmail(String email) {
//        return repository.findByEmail(email);
//    }
//
//    @Override
//    public Customer deleteCustomer(String email) {
//        return repository.deleteCustomer(email);
//    }

    public Customer findCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
