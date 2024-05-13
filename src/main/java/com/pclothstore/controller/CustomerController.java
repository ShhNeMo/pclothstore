
package com.pclothstore.controller;

import com.pclothstore.model.Customer;
import com.pclothstore.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")

public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

//    @GetMapping("/{email}")
//    public Customer findByEmail(@PathVariable String email){
//        return customerService.findByEmail(email);
//    }

    @PutMapping("")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
//
//    @DeleteMapping("/{email}")
//    public void deleteCustomer(@PathVariable String email){
//        customerService.deleteCustomer(email);
//    }
}