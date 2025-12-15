package com.vitochianese.template.controller;

import com.vitochianese.template.dto.UserDto;
import com.vitochianese.template.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserDto> getUsers() {
        return service.findAll();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("Creating new user with email {}", userDto.getEmail());
        return service.save(userDto);
    }
}
