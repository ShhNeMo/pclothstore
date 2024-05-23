package com.pclothstore.service.impl;

import com.pclothstore.model.ExternalUser;
import com.pclothstore.service.ExternalUserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExternalUserServiceImpl implements ExternalUserService {

    private final Map<Long, ExternalUser> users = new HashMap<>();
    private long nextId = 1;

    @Override
    public ExternalUser getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public List<ExternalUser> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public ExternalUser createUser(ExternalUser user) {
        user.setId(nextId++);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public ExternalUser updateUser(Long id, ExternalUser user) {
        if (!users.containsKey(id)) {
            throw new RuntimeException("User not found");
        }
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }
}
