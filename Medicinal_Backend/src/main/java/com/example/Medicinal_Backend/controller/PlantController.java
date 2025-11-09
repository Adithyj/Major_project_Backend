package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.Plant;
import com.example.Medicinal_Backend.service.PlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin(origins = "*")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id).orElse(null);
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.savePlant(plant);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }

    // ✅ renamed endpoint to avoid conflict
    @PostMapping("/identify/list")
    public List<Plant> identifyPlants(@RequestBody List<String> detectedPlantNames) {
        // detectedPlantNames comes from your ML model output
        return plantService.getPlantsByNames(detectedPlantNames);
    }
}
