package com.example.exercice2.service;

import com.example.exercice2.entity.Realisateur;
import com.example.exercice2.repository.RealisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository repository;

    public RealisateurService(RealisateurRepository repository) {
        this.repository = repository;
    }

    public List<Realisateur> getAll() { return repository.findAll(); }
    public Realisateur getById(Long id) { return repository.findById(id).orElseThrow(); }
    public Realisateur create(Realisateur r) { return repository.save(r); }
    public Realisateur update(Long id, Realisateur r) {
        Realisateur existing = getById(id);
        existing.setNom(r.getNom());
        existing.setPrenom(r.getPrenom());
        existing.setDateNaissance(r.getDateNaissance());
        existing.setNationalite(r.getNationalite());
        return repository.save(existing);
    }
    public void delete(Long id) { repository.deleteById(id); }
}

