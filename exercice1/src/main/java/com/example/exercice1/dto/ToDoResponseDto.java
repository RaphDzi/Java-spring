package com.example.exercice1.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ToDoResponseDto {

    private Long id;
    private String titre;
    private String description;
    private LocalDate date;
    private boolean isValidate;
}
