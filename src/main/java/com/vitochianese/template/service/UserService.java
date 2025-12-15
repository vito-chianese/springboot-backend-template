package com.vitochianese.template.service;

import com.vitochianese.template.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
}
