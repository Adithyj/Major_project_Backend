package com.example.Medicinal_Backend.service;

import com.example.Medicinal_Backend.model.Plant;
import com.example.Medicinal_Backend.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }

    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
    public List<Plant> getPlantsByNames(List<String> plantNames) {
        return plantRepository.findByPlantNameIn(plantNames);
    }
}
