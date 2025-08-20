package com.example.exercice4.dto;

import com.example.exercice4.model.CreatureType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatureResponseDto {
    private long id;
    private String name;
    private int age;
    private double weight;
    private boolean dangerous;
    @Enumerated(EnumType.STRING)
    private CreatureType type;
}
