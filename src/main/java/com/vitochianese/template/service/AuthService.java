package com.vitochianese.template.service;

import com.vitochianese.template.dto.AuthResponse;
import com.vitochianese.template.dto.LoginRequest;
import com.vitochianese.template.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}

