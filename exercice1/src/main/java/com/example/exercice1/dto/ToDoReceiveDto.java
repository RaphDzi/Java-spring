package com.example.exercice1.dto;

import com.example.exercice1.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoReceiveDto {
    private String titre;
    private String description;
    private String dateStr;
    private boolean isValidate;

    public ToDo dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ToDo.builder()
                .titre(titre)
                .description(description)
                .date(LocalDate.parse(dateStr, formatter))
                .isValidate(isValidate)
                .build();
    }
}
