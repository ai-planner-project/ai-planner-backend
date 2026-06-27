package com.example.aistudyplanner.goal.dto;

import com.example.aistudyplanner.goal.entity.GoalIntensity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GoalCreateRequest {

    @NotBlank(message = "목표명은 필수입니다.")
    private String title;

    private String description;

    @NotNull(message = "목표 완료일은 필수입니다.")
    @FutureOrPresent(message = "목표 완료일은 오늘 이후여야 합니다.")
    private LocalDate targetDate;

    @NotNull(message = "학습 강도는 필수입니다.")
    private GoalIntensity intensity;
}