package com.example.exercice2.repository;

import com.example.exercice2.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByRealisateurId(Long realisateurId);
    List<Film> findByGenreIgnoreCase(String genre);

}
