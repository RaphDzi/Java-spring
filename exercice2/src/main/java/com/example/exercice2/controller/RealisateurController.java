package com.example.exercice2.controller;

import com.example.exercice2.entity.Realisateur;
import com.example.exercice2.service.RealisateurService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/catalogue/realisateur")
public class RealisateurController {
    private final RealisateurService service;

    public RealisateurController(RealisateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<Realisateur> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Realisateur getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Realisateur create(@RequestBody Realisateur r) { return service.create(r); }

    @PutMapping("/{id}")
    public Realisateur update(@PathVariable Long id, @RequestBody Realisateur r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
