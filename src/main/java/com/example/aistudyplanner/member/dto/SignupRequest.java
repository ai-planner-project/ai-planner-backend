package com.example.aistudyplanner.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class SignupRequest {

    @NotBlank(message = "고유ID는 필수입니다.")
    @Pattern(
            regexp = "^@[a-z0-9_]+$",
            message = "고유ID는 @로 시작해야 하며, 영문 소문자·숫자·언더바만 사용할 수 있습니다."
    )
    private String customId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    @NotBlank(message = "닉네임은 필수입니다.")
    private String nickname;
}