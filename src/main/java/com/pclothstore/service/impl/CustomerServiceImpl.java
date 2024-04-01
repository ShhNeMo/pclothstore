package com.pclothstore.service.impl;

import com.pclothstore.model.Customer;
import com.pclothstore.repository.CustomerRepository;
import com.pclothstore.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Primary
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer findByEmail(String email) {
        return repository.findCustomerByEmail(email);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    @Transactional
    public Customer deleteCustomer(String email) {
        repository.deleteByEmail(email);
        return null;
    }
}
