package com.example.aistudyplanner.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String customId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Member(String customId, String password, String nickname) {
        this.customId = customId;
        this.password = password;
        this.nickname = nickname;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}