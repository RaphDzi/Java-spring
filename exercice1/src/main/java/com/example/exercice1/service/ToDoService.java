package com.example.exercice1.service;


import com.example.exercice1.dto.ToDoReceiveDto;
import com.example.exercice1.dto.ToDoResponseDto;
import com.example.exercice1.entity.ToDo;
import com.example.exercice1.exception.NotFoundException;
import com.example.exercice1.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
    public ToDoResponseDto create(ToDoReceiveDto toDoReceiveDto) {
        return toDoRepository.save(toDoReceiveDto.dtoToEntity()).entityToDto();
        // toDoReceiveDto => dtoToEntity => toDo mis en BDD => entityToDto => toDoResponseDto
    }

    public ToDoResponseDto get(long id) {
        return toDoRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<ToDoResponseDto> get(){return toDoRepository.findAll().stream().map(ToDo::entityToDto).toList();
    }

    public ToDoResponseDto update(long id, ToDoReceiveDto ToDoReceiveDto){
        ToDo toDoFound = toDoRepository.findById(id).orElseThrow(NotFoundException::new);
        ToDo toDoGet = ToDoReceiveDto.dtoToEntity();
        toDoFound.setTitre(toDoGet.getTitre());
        toDoFound.setDescription(toDoGet.getDescription());
        toDoFound.setDate(toDoGet.getDate());
        toDoFound.setValidate(toDoGet.isValidate());
        return toDoRepository.save(toDoFound).entityToDto();
    }

    public void delete(long id){toDoRepository.deleteById(id);}
}
