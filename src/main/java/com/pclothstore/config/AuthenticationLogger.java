package com.pclothstore.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogger implements AuthenticationObserver {
    @Override
    public void onAuthenticationSuccess(UserDetails userDetails) {
        System.out.println("Пользователь успешно аутентифицирован: " + userDetails.getUsername());
    }

    @Override
    public void onAuthenticationFailure(String errorMessage) {
        System.out.println("Ошибка аутентификации: " + errorMessage);
    }
}
