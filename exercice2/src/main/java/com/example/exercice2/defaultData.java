package com.example.exercice2;

import com.example.exercice2.entity.Film;
import com.example.exercice2.entity.Realisateur;
import com.example.exercice2.repository.FilmRepository;
import com.example.exercice2.repository.RealisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.time.LocalDate;

@Configuration
public class defaultData {

    @Bean
    CommandLineRunner initDatabase(FilmRepository filmRepo, RealisateurRepository realisateurRepo) {
        return args -> {
            // --- Réalisateurs ---
            Realisateur spielberg = new Realisateur(null, "Spielberg", "Steven", LocalDate.of(1946, 12, 18), "Américaine","");
            Realisateur nolan = new Realisateur(null, "Nolan", "Christopher", LocalDate.of(1970, 7, 30), "Britannique", List<"">);
            Realisateur tarantino = new Realisateur(null, "Tarantino", "Quentin", LocalDate.of(1963, 3, 27), "Américaine","");

            realisateurRepo.save(spielberg);
            realisateurRepo.save(nolan);
            realisateurRepo.save(tarantino);

            // --- Films ---
            filmRepo.save(new Film(null, "Jurassic Park", LocalDate.of(1993, 6, 11), "Un parc rempli de dinosaures.", 127, "Science-Fiction", spielberg));
            filmRepo.save(new Film(null, "Inception", LocalDate.of(2010, 7, 16), "Un voleur infiltre les rêves.", 148, "Science-Fiction", nolan));
            filmRepo.save(new Film(null, "Pulp Fiction", LocalDate.of(1994, 10, 14), "Histoires entrelacées de gangsters.", 154, "Crime", tarantino));
            filmRepo.save(new Film(null, "Interstellar", LocalDate.of(2014, 11, 7), "Voyage à travers l’espace et le temps.", 169, "Science-Fiction", nolan));
        };
    }
}
