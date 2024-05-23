package com.pclothstore.service;

import com.pclothstore.model.ExternalUser;

import java.util.List;

public interface ExternalUserService {
    ExternalUser getUserById(Long id);
    List<ExternalUser> getAllUsers();
    ExternalUser createUser(ExternalUser user);
    ExternalUser updateUser(Long id, ExternalUser user);
    void deleteUser(Long id);
}

