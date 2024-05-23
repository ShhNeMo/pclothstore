package com.pclothstore.service;

import com.pclothstore.model.Customer;
import com.pclothstore.model.ExternalUser;
import com.pclothstore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExternalUserServiceAdapter implements CustomerService {

    private final ExternalUserService externalUserService;

    private Customer toCustomer(ExternalUser externalUser) {
        return Customer.builder()
                .id(externalUser.getId())
                .firstName(externalUser.getFirstName())
                .lastName(externalUser.getLastName())
                .email(externalUser.getEmail())
                .build();
    }

    private ExternalUser toExternalUser(Customer customer) {
        ExternalUser externalUser = new ExternalUser();
        externalUser.setId(customer.getId());
        externalUser.setFirstName(customer.getFirstName());
        externalUser.setLastName(customer.getLastName());
        externalUser.setEmail(customer.getEmail());
        return externalUser;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return externalUserService.getAllUsers().stream()
                .map(this::toCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Customer createCustomer(Customer customer) {
        ExternalUser externalUser = externalUserService.createUser(toExternalUser(customer));
        return toCustomer(externalUser);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        ExternalUser externalUser = externalUserService.updateUser(id, toExternalUser(customer));
        return toCustomer(externalUser);
    }

    @Override
    public Customer findCustomerById(Long id) {
        ExternalUser externalUser = externalUserService.getUserById(id);
        return toCustomer(externalUser);
    }

    @Override
    public void deleteCustomer(Long id) {
        externalUserService.deleteUser(id);
    }
}

