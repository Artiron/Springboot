package com.risa.boot.demo.service.api;

import com.risa.boot.demo.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
