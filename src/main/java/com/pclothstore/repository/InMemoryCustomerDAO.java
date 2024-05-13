package com.pclothstore.repository;

import com.pclothstore.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class InMemoryCustomerDAO {
    private final List<Customer> CUSTOMERS = new ArrayList<>();

    public List<Customer> findAllCustomers() {
        return CUSTOMERS;
    }

    public Customer createCustomer(Customer customer) {
        CUSTOMERS.add(customer);
        return customer;
    }

//    public Customer findByEmail(String email) {
//        return CUSTOMERS.stream()
//                .filter(element-> element.getEmail().equals(email))
//                .findFirst()
//                .orElse(null);
//    }

    public Customer updateCustomer(Customer customer) {
        var customerIndex = IntStream.range(0, CUSTOMERS.size())
                .filter(index->CUSTOMERS.get(index).getEmail().equals(customer.getEmail()))
                .findFirst()
                .orElse(-1);

        if (customerIndex>-1){
            CUSTOMERS.set(customerIndex, customer);
            return customer;
        }
        return null;
    }

//    public Customer deleteCustomer(String email) {
//        var customer = findByEmail(email);
//        if(customer!=null){
//            CUSTOMERS.remove(customer);
//        }
//        return null;
//    }


    public Optional<Customer> findById(Long id) {
        return CUSTOMERS.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
    public void deleteById(Long id) {
        CUSTOMERS.removeIf(customer -> customer.getId().equals(id));
    }
}
