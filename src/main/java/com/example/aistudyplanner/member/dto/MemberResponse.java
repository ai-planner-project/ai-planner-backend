package com.example.aistudyplanner.member.dto;

import com.example.aistudyplanner.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private Long userId;
    private String customId;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getUserId(),
                member.getCustomId(),
                member.getNickname(),
                member.getCreatedAt(),
                member.getUpdatedAt()
        );
    }
}