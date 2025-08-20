package com.example.exercice4.model;

import com.example.exercice4.dto.CreatureResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Creature {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
    private double weight;
    private boolean dangerous;
    @Enumerated(EnumType.STRING)
    private CreatureType type;

    public Creature(){}

    public Creature(String name,int age,double weight,boolean dangerous, CreatureType type){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.dangerous=dangerous;
        this.type=type;
    }

    public CreatureResponseDto entityToDto() {
        return CreatureResponseDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .type(type)
                .build();
    }
}
