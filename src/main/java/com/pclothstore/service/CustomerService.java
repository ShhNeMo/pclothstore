package com.pclothstore.service;


import com.pclothstore.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();

    Customer createCustomer(Customer customer);

//    Customer findByEmail(String email);

    Customer updateCustomer(Customer customer);

//    Customer deleteCustomer(String email);

    Customer findCustomerById(Long id);
    void deleteCustomer(Long id);
}