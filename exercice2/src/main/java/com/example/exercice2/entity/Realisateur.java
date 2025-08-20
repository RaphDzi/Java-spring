package com.example.exercice2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Realisateur extends Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;

    @OneToMany(mappedBy = "realisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Film> films;

}
