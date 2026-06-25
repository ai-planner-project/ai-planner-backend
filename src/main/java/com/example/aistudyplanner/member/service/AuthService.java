package com.example.aistudyplanner.member.service;

import com.example.aistudyplanner.global.dto.ApiResponse;
import com.example.aistudyplanner.member.dto.CheckIdResponse;
import com.example.aistudyplanner.member.dto.LoginRequest;
import com.example.aistudyplanner.member.dto.LoginResponse;
import com.example.aistudyplanner.member.dto.SignupRequest;
import com.example.aistudyplanner.member.entity.Member;
import com.example.aistudyplanner.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ApiResponse signup(SignupRequest request) {
        if (memberRepository.existsByCustomId(request.getCustomId())) {
            return new ApiResponse(false, "이미 사용 중인 고유ID입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Member member = new Member(
                request.getCustomId(),
                encodedPassword,
                request.getNickname()
        );

        memberRepository.save(member);

        return new ApiResponse(true, "회원가입이 완료되었습니다.");
    }

    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByCustomId(request.getCustomId())
                .orElseThrow(() -> new IllegalArgumentException("고유ID 또는 비밀번호가 올바르지 않습니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("고유ID 또는 비밀번호가 올바르지 않습니다.");
        }

        return new LoginResponse("jwt-access-token", "jwt-refresh-token");
    }

    public CheckIdResponse checkCustomId(String customId) {
        boolean exists = memberRepository.existsByCustomId(customId);

        if (exists) {
            return new CheckIdResponse(false, "이미 사용 중인 고유ID입니다.");
        }

        return new CheckIdResponse(true, "사용 가능한 고유ID입니다.");
    }
}