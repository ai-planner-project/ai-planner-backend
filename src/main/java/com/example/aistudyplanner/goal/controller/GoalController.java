package com.example.aistudyplanner.goal.controller;

import com.example.aistudyplanner.goal.dto.GoalCreateRequest;
import com.example.aistudyplanner.goal.dto.GoalResponse;
import com.example.aistudyplanner.goal.service.GoalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @PostMapping
    public GoalResponse createGoal(
            Authentication authentication,
            @Valid @RequestBody GoalCreateRequest request
    ) {
        Long userId = (Long) authentication.getPrincipal();

        return goalService.createGoal(userId, request);
    }

    @GetMapping
    public List<GoalResponse> getGoals(Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();

        return goalService.getGoals(userId);
    }
}