package com.example.aistudyplanner.goal.service;

import com.example.aistudyplanner.goal.dto.GoalCreateRequest;
import com.example.aistudyplanner.goal.dto.GoalResponse;
import com.example.aistudyplanner.goal.entity.Goal;
import com.example.aistudyplanner.goal.repository.GoalRepository;
import com.example.aistudyplanner.member.entity.Member;
import com.example.aistudyplanner.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GoalService {

    private final GoalRepository goalRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public GoalResponse createGoal(Long userId, GoalCreateRequest request) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Goal goal = new Goal(
                member,
                request.getTitle(),
                request.getDescription(),
                request.getTargetDate(),
                request.getIntensity()
        );

        Goal savedGoal = goalRepository.save(goal);

        return GoalResponse.from(savedGoal);
    }

    public List<GoalResponse> getGoals(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return goalRepository.findAllByMember(member)
                .stream()
                .map(GoalResponse::from)
                .toList();
    }
}