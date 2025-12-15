package com.vitochianese.template.service;

import com.vitochianese.template.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto save(UserDto userDto);
}
