package com.example.aistudyplanner.goal.dto;

import com.example.aistudyplanner.goal.entity.Goal;
import com.example.aistudyplanner.goal.entity.GoalIntensity;
import com.example.aistudyplanner.goal.entity.GoalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GoalResponse {

    private Long goalId;
    private String title;
    private String description;
    private LocalDate targetDate;
    private GoalIntensity intensity;
    private GoalStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static GoalResponse from(Goal goal) {
        return new GoalResponse(
                goal.getGoalId(),
                goal.getTitle(),
                goal.getDescription(),
                goal.getTargetDate(),
                goal.getIntensity(),
                goal.getStatus(),
                goal.getCreatedAt(),
                goal.getUpdatedAt()
        );
    }
}