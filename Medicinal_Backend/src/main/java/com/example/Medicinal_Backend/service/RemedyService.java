package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.Remedy;
import com.example.Medicinal_Backend.repository.RemedyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedyService {

    private final RemedyRepository repository;

    public RemedyService(RemedyRepository repository) {
        this.repository = repository;
    }

    public List<Remedy> getAllRemedies() {
        return repository.findAll();
    }

    public Optional<Remedy> getRemedyById(Long id) {
        return repository.findById(id);
    }

    public Remedy saveRemedy(Remedy remedy) {
        return repository.save(remedy);
    }

    public void deleteRemedy(Long id) {
        repository.deleteById(id);
    }
}
