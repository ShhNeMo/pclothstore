package com.pclothstore.config;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;

@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

    private final AuthenticationObserver authenticationObserver;

    public AuthenticationEventListener(AuthenticationObserver authenticationObserver) {
        this.authenticationObserver = authenticationObserver;
    }

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        if (event instanceof AuthenticationSuccessEvent successEvent) {
            authenticationObserver.onAuthenticationSuccess((UserDetails) successEvent.getAuthentication().getPrincipal());
        } else if (event instanceof AuthenticationFailureBadCredentialsEvent) {
            authenticationObserver.onAuthenticationFailure("Bad credentials");
        }
    }
}
