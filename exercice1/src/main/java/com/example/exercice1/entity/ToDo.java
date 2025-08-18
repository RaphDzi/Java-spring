package com.example.exercice1.entity;



import com.example.exercice1.dto.ToDoResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDate;



@Entity
@Table(name = "todos")
@Data // si tu utilises Lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private LocalDate date;
    private boolean isValidate;


    public ToDoResponseDto entityToDto(){
        return ToDoResponseDto.builder()
                .id(id)
                .titre(titre)
                .description(description)
                .date(date)
                .isValidate(isValidate)
                .build();
    }
}
