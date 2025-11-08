package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.PlantMedicine;
import com.example.Medicinal_Backend.repository.PlantMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantMedicineService {

    private final PlantMedicineRepository repository;

    public PlantMedicineService(PlantMedicineRepository repository) {
        this.repository = repository;
    }

    public List<PlantMedicine> getAllRelations() {
        return repository.findAll();
    }

    public PlantMedicine saveRelation(PlantMedicine relation) {
        return repository.save(relation);
    }

    public void deleteRelation(Long id) {
        repository.deleteById(id);
    }
}
