package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.PlantSymptom;
import com.example.Medicinal_Backend.repository.PlantSymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantSymptomService {

    private final PlantSymptomRepository repository;

    public PlantSymptomService(PlantSymptomRepository repository) {
        this.repository = repository;
    }

    public List<PlantSymptom> getAllSymptoms() {
        return repository.findAll();
    }

    public PlantSymptom saveSymptom(PlantSymptom symptom) {
        return repository.save(symptom);
    }

    public void deleteSymptom(Long id) {
        repository.deleteById(id);
    }
}
