package com.example.exercice3.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produit {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prix;

}
