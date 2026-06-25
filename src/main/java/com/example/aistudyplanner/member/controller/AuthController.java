package com.example.aistudyplanner.member.controller;

import com.example.aistudyplanner.global.dto.ApiResponse;
import com.example.aistudyplanner.member.dto.CheckIdResponse;
import com.example.aistudyplanner.member.dto.LoginRequest;
import com.example.aistudyplanner.member.dto.LoginResponse;
import com.example.aistudyplanner.member.dto.SignupRequest;
import com.example.aistudyplanner.member.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ApiResponse signup(@Valid @RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/check-id")
    public CheckIdResponse checkCustomId(@RequestParam String customId) {
        return authService.checkCustomId(customId);
    }
}