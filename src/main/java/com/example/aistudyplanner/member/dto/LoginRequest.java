package com.example.aistudyplanner.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank(message = "고유ID는 필수입니다.")
    private String customId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}