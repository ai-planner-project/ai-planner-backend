package com.example.aistudyplanner.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CheckIdResponse {

    private boolean available;
    private String message;
}