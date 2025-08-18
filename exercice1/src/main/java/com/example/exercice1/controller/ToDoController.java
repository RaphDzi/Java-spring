package com.example.exercice1.controller;

import com.example.exercice1.dto.ToDoReceiveDto;
import com.example.exercice1.dto.ToDoResponseDto;
import com.example.exercice1.service.ToDoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public ResponseEntity<List<ToDoResponseDto>> getAll(){return ResponseEntity.ok(toDoService.get());}

    @GetMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> getOne(@PathVariable long id) {
        return ResponseEntity.ok(toDoService.get(id));
    }

    @PostMapping
    public ResponseEntity<ToDoResponseDto> create(@RequestBody ToDoReceiveDto toDoReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(toDoReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponseDto> update(@PathVariable long id, @RequestBody ToDoReceiveDto toDoReceiveDto) {
        return ResponseEntity.ok(toDoService.update(id, toDoReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        toDoService.delete(id);
        return ResponseEntity.ok(String.format("Delete toDo with id %d", id));
    }
}
