package com.example.exercice4.dto;

import com.example.exercice4.model.Creature;
import com.example.exercice4.model.CreatureType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatureReceiveDto {

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 3, max = 30, message = "Le nom doit contenir entre 3 et 30 caractères")
    private String name;

    @Min(value = 0, message = "L'âge doit être positif")
    @Max(value = 500, message = "Une créature ne peut pas avoir plus de 500 ans")
    private int age;

    @DecimalMin(value = "50.0", message = "Le poids doit être au minimum de 50kg")
    @DecimalMax(value = "250.0", message = "Le poids ne doit pas dépasser 250kg")
    private double weight;

    private boolean dangerous;

    @NotNull(message = "Le type de créature est obligatoire")
    private CreatureType type;

    // Conversion DTO -> Entity
    public Creature dtoToEntity() {
        return Creature.builder()
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .type(type)
                .build();
    }
}
