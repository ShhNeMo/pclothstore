//package com.pclothstore.service.impl;
//
//import com.pclothstore.model.Customer;
//
//import com.pclothstore.repository.InMemoryCustomerDAO;
//
//import com.pclothstore.service.CustomerService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import com.pclothstore.repository.CustomerRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//@AllArgsConstructor
//public class InMemoryCustomerServiceImpl implements CustomerService {
//    private final InMemoryCustomerDAO repository;
//
//
//    @Override
//    public List<Customer> findAllCustomers() {
//        return repository.findAllCustomers();
//    }
//
//    @Override
//    public Customer createCustomer(Customer customer) {
//        return repository.createCustomer(customer);
//    }
//
//
//    @Override
//    public Customer updateCustomer(Long id, Customer customer) {
//        Customer existingCustomer = findCustomerById(id);
//
//        existingCustomer.setFirstName(customer.getFirstName());
//        existingCustomer.setLastName(customer.getLastName());
//        existingCustomer.setEmail(customer.getEmail());
//        existingCustomer.setPassword(customer.getPassword());
//
//        return repository.save(existingCustomer);
//    }
//
////    @Override
////    public Customer findByEmail(String email) {
////        return repository.findByEmail(email);
////    }
////
////    @Override
////    public Customer deleteCustomer(String email) {
////        return repository.deleteCustomer(email);
////    }
//
//    public Customer findCustomerById(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//    }
//
//    @Override
//    public void deleteCustomer(Long id) {
//        repository.deleteById(id);
//    }
//}
