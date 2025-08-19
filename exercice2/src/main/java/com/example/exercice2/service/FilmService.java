package com.example.exercice2.service;

import com.example.exercice2.entity.Film;
import com.example.exercice2.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    public List<Film> getAll() {
        return repository.findAll();
    }

    public Film getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    // Correction : List et repository au lieu de filmRepository
    public List<Film> getByGenre(String genre) {
        return repository.findByGenreIgnoreCase(genre);
    }

    public Film create(Film film) {
        return repository.save(film);
    }

    public Film update(Long id, Film film) {
        Film existing = getById(id);
        existing.setNom(film.getNom());
        existing.setDateSortie(film.getDateSortie());
        existing.setDescription(film.getDescription());
        existing.setDuree(film.getDuree());
        existing.setGenre(film.getGenre());
        existing.setRealisateur(film.getRealisateur());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Film> getByRealisateur(Long realisateurId) {
        return repository.findByRealisateurId(realisateurId);
    }
}
