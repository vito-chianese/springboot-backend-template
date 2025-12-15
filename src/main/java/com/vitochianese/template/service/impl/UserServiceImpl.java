package com.vitochianese.template.service.impl;

import com.vitochianese.template.dto.UserDto;
import com.vitochianese.template.mapper.UserMapper;
import com.vitochianese.template.model.User;
import com.vitochianese.template.repository.UserRepository;
import com.vitochianese.template.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public List<UserDto> findAll() {
        log.info("Fetching all users");
        return repo.findAll().stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @Override
    public UserDto save(UserDto userDto) {
        User saved = repo.save(UserMapper.toEntity(userDto));
        return UserMapper.toDto(saved);
    }

}
