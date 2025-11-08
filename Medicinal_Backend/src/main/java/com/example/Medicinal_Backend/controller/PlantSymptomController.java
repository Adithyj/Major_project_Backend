package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.PlantSymptom;
import com.example.Medicinal_Backend.service.PlantSymptomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plant-symptoms")
@CrossOrigin(origins = "*")
public class PlantSymptomController {

    private final PlantSymptomService service;

    public PlantSymptomController(PlantSymptomService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlantSymptom> getAll() {
        return service.getAllSymptoms();
    }

    @PostMapping
    public PlantSymptom add(@RequestBody PlantSymptom symptom) {
        return service.saveSymptom(symptom);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSymptom(id);
    }
}
