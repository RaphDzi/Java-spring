package com.example.exercice5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private LocalDateTime date;
    private Boolean isValidate;

    public ToDo(String titre, String description, LocalDateTime date, Boolean isValidate) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.isValidate = isValidate;
    }

}
