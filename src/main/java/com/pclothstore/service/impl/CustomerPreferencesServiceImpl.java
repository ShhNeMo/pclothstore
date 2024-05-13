package com.pclothstore.service.impl;

import com.pclothstore.model.CustomerPreferences;
import com.pclothstore.repository.CustomerPreferencesRepository;
import com.pclothstore.service.CustomerPreferencesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.pclothstore.service.CustomerService;


import java.util.List;

@AllArgsConstructor
@Service
public class CustomerPreferencesServiceImpl implements CustomerPreferencesService {
    private final CustomerService customerService;
    private final CustomerPreferencesRepository preferencesRepository;

    @Override
    public List<CustomerPreferences> getCustomerPreferences(Long customerId) {
        return preferencesRepository.findByCustomerId(customerId);
    }

    @Override
    public void updateCustomerPreferences(Long customerId, CustomerPreferences preferences) {
        if (customerExists(customerId)) {
            preferences.setCustomerId(customerId);
            preferencesRepository.save(preferences);
        }
    }

    @Override
    public void deleteCustomerPreference(Long customerId, Long preferenceId) {
        preferencesRepository.deleteByIdAndCustomerId(preferenceId, customerId);
    }

    @Override
    public void addCustomerPreference(Long customerId, CustomerPreferences preference) {
        if (customerExists(customerId)) {
            preference.setCustomerId(customerId);
            preferencesRepository.save(preference);
        }
    }

    private boolean customerExists(Long customerId) {
        try {
            customerService.findCustomerById(customerId);
            return true;
        } catch (RuntimeException ex) {
            return false;
        }
    }
}
