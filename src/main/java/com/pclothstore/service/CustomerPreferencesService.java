package com.pclothstore.service;

import com.pclothstore.model.CustomerPreferences;

import java.util.List;

public interface CustomerPreferencesService {
    List<CustomerPreferences> getCustomerPreferences(Long customerId);
    void updateCustomerPreferences(Long customerId, CustomerPreferences preferences);
    void deleteCustomerPreference(Long customerId, Long preferenceId);
    void addCustomerPreference(Long customerId, CustomerPreferences preference);
}
