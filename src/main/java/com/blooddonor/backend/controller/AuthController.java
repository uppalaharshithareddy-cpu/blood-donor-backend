package com.blooddonor.backend.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blooddonor.backend.User;
import com.blooddonor.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
       
try {
    User user = authService.register(
            body.get("username"),
            body.get("password"),
            "DONOR"
    );


            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Map.of(
                            "message", "Account created successfully",
                            "username", user.getUsername(),
                            "role", user.getRole()
                    )
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(
                    Map.of("message", ex.getMessage())
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        boolean valid = authService.login(
                body.get("username"),
                body.get("password"),
                body.get("role")
        );

        if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    Map.of("message", "Invalid username, password, or role")
            );
        }

        return ResponseEntity.ok(
                Map.of("message", "Login credentials are correct")
        );
    }
}
