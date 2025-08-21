package com.example.exercice5.service;

import com.example.exercice5.dto.RegisterRequestDto;
import com.example.exercice5.entity.ToDo;
import com.example.exercice5.repository.ToDoRepository;

import java.util.Optional;

public class ToDoService {

    private final ToDoRepository toDoRepository;
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo enregistrerToDo(RegisterRequestDto registerRequestDto) throws ToDoAlreadyExistException {
        Optional<ToDo> toDoOptional = toDoRepository.findByEmail(registerRequestDto.getEmail());
        // public ToDo(String firstName, String lastName, String email, String phone, String password, int role)
        if(toDoOptional.isEmpty()){
            ToDo toDo = new ToDo(
                    registerRequestDto.getTitre(),
                    registerRequestDto.getDescription(),
                    registerRequestDto.getDate(),
                    registerRequestDto.getIsValidate());
            return toDoRepository.save(toDo);
        }
        // email present en bdd je ne peux enregistrer ce nouvelle utilisateur
        throw new ToDoAlreadyExistException();
    }
}
