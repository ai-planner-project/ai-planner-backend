package com.example.aistudyplanner.goal.repository;

import com.example.aistudyplanner.goal.entity.Goal;
import com.example.aistudyplanner.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findAllByMember(Member member);
}