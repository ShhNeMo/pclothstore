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

//    @Override
//    public Customer findByEmail(String email) {
//        return repository.findCustomerByEmail(email);
//    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = findCustomerById(id);

        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());

        return repository.save(existingCustomer);
    }

//    @Override
//    @Transactional
//    public Customer deleteCustomer(String email) {
//        repository.deleteByEmail(email);
//        return null;
//    }

    @Override
    public Customer findCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

}