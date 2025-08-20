package com.example.exercice4.controller;

import com.example.exercice4.dto.CreatureReceiveDto;
import com.example.exercice4.dto.CreatureResponseDto;
import com.example.exercice4.service.CreatureService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/creatures")
public class CreatureController {

    private final CreatureService creatureService;

    public CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<CreatureResponseDto>> getAll() {
        return ResponseEntity.ok(creatureService.getAll());
    }

    // GET one by id
    @GetMapping("/{id}")
    public ResponseEntity<CreatureResponseDto> getOne(@PathVariable long id) {
        return ResponseEntity.ok(creatureService.getOne(id));
    }

    // POST create
    @PostMapping
    public ResponseEntity<CreatureResponseDto> create(@Valid @RequestBody CreatureReceiveDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creatureService.create(dto));
    }

    // PUT update
    @PutMapping("/{id}")
    public ResponseEntity<CreatureResponseDto> update(@PathVariable long id, @Valid @RequestBody CreatureReceiveDto dto) {
        return ResponseEntity.ok(creatureService.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        creatureService.delete(id);
        return ResponseEntity.ok(String.format("Delete creature with id %d", id));
    }

    // GET with pagination
    @GetMapping("/paged")
    public Page<CreatureResponseDto> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String sortField,
            @RequestParam(defaultValue = "asc") String direction) {

        if (sortField != null) {
            Sort sort = direction.equalsIgnoreCase("desc")
                    ? Sort.by(sortField).descending()
                    : Sort.by(sortField).ascending();
            return creatureService.getPage(PageRequest.of(page, size, sort));
        } else {
            return creatureService.getPage(PageRequest.of(page, size));
        }
    }
}
