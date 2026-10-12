package com.blooddonor.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blooddonor.backend.User;
import com.blooddonor.backend.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(
            String username,
            String password,
            String role) {

        if (username == null || username.isBlank()
                || password == null || password.length() < 8) {
            throw new IllegalArgumentException(
                    "Username is required and password must be at least 8 characters.");
        }

        if (!"DONOR".equals(role) && !"ADMIN".equals(role)) {
            throw new IllegalArgumentException("Invalid role.");
        }

        if (userRepository.findByUsername(username.trim()).isPresent()) {
            throw new IllegalArgumentException("Username already exists.");
        }

        User user = new User();
        user.setUsername(username.trim());
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        return userRepository.save(user);
    }

    public boolean login(
            String username,
            String password,
            String requestedRole) {

        if (username == null || password == null
                || requestedRole == null) {
            return false;
        }

        return userRepository.findByUsername(username.trim())
                .filter(user -> user.getRole().equals(requestedRole))
                .map(user -> passwordEncoder.matches(
                        password, user.getPassword()))
                .orElse(false);
    }
}

