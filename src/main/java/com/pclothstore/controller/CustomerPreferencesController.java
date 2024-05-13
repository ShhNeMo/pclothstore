package com.pclothstore.controller;

import com.pclothstore.config.JwtService;
import com.pclothstore.model.CustomerPreferences;
import com.pclothstore.service.CustomerPreferencesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/preferences")
public class CustomerPreferencesController {

    private final CustomerPreferencesService preferencesService;
    @Autowired
    public CustomerPreferencesController(CustomerPreferencesService preferencesService) {
        this.preferencesService = preferencesService;
    }

    @GetMapping("/{customerId}")
    public List<CustomerPreferences> getCustomerPreferences(@PathVariable Long customerId) {
        return preferencesService.getCustomerPreferences(customerId);
    }

    @PostMapping("/{customerId}")
    public void updateCustomerPreferences(@PathVariable Long customerId, @RequestBody CustomerPreferences preferences) {
        preferencesService.updateCustomerPreferences(customerId, preferences);
    }

    @DeleteMapping("/{customerId}/{preferenceId}")
    public void deleteCustomerPreference(@PathVariable Long customerId, @PathVariable Long preferenceId) {
        preferencesService.deleteCustomerPreference(customerId, preferenceId);
    }

    @PostMapping("/{customerId}/add")
    public ResponseEntity<?> addCustomerPreference(@PathVariable Long customerId, @RequestBody CustomerPreferences preference) {
        try {
            preferencesService.addCustomerPreference(customerId, preference);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
