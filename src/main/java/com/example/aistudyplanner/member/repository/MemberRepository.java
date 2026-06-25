package com.example.aistudyplanner.member.repository;

import com.example.aistudyplanner.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByCustomId(String customId);

    boolean existsByCustomId(String customId);
}