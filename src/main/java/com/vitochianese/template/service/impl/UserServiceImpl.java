package com.vitochianese.template.service.impl;

import com.vitochianese.template.model.User;
import com.vitochianese.template.repository.UserRepository;
import com.vitochianese.template.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

}
