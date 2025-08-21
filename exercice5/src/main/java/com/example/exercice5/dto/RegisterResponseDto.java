package com.example.exercice5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterResponseDto {
    private int id;
    private String titre;
    private String description;
    private LocalDateTime date;
    private Boolean isValidate;
}