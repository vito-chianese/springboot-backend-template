package com.vitochianese.template.controller;

import com.vitochianese.template.model.User;
import com.vitochianese.template.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getUsers() {
        return service.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.save(user);
    }
}
