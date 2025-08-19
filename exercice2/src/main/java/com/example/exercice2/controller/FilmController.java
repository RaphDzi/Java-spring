package com.example.exercice2.controller;

import com.example.exercice2.entity.Film;
import com.example.exercice2.service.FilmService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/catalogue/films")
public class FilmController {
    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }

    // Récupérer tous les films ou filtrer par genre
    @GetMapping
    public List<Film> getFilms(@RequestParam(required = false) String genre) {
        if (genre != null) {
            return service.getByGenre(genre);
        }
        return service.getAll();
    }

    // Récupérer un film par ID
    @GetMapping("/{id}")
    public Film getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Créer un film
    @PostMapping
    public Film create(@RequestBody Film film) {
        return service.create(film);
    }

    // Modifier un film
    @PutMapping("/{id}")
    public Film update(@PathVariable Long id, @RequestBody Film film) {
        return service.update(id, film);
    }

    // Supprimer un film
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // Récupérer les films par réalisateur
    @GetMapping("/realisateur/{id}")
    public List<Film> getByRealisateur(@PathVariable Long id) {
        return service.getByRealisateur(id);
    }
}
