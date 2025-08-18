package com.example.exercice1.repository;


import com.example.exercice1.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByIsValidate(boolean isValidate);
}
