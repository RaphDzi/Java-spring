package com.example.exercice2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private LocalDate dateSortie;
    private String description;
    private int duree; // minutes
    private String genre;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;
}
