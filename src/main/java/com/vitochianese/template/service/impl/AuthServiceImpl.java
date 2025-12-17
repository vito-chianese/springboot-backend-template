package com.vitochianese.template.service.impl;

import com.vitochianese.template.dto.AuthResponse;
import com.vitochianese.template.dto.LoginRequest;
import com.vitochianese.template.dto.RegisterRequest;
import com.vitochianese.template.model.Role;
import com.vitochianese.template.model.User;
import com.vitochianese.template.repository.UserRepository;
import com.vitochianese.template.security.JwtService;
import com.vitochianese.template.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(Role.USER)
                .build();

        repo.save(user);
        String token = jwtService.generateToken(user.getEmail());
        log.info("Generated JWT for {} -> {}", user.getEmail(), token);

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest req) {
        User user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponse(jwtService.generateToken(user.getEmail()));
    }
}

