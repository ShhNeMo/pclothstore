package com.pclothstore.config;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationObserver {
    void onAuthenticationSuccess(UserDetails userDetails);
    void onAuthenticationFailure(String errorMessage);
}
