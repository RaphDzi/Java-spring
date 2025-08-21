package com.example.exercice5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    private int id;
    private String titre;
    private String description;
    private LocalDateTime date;
    private Boolean isValidate;
}