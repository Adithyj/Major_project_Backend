package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.PlantMedicine;
import com.example.Medicinal_Backend.service.PlantMedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plant-medicines")
@CrossOrigin(origins = "*")
public class PlantMedicineController {

    private final PlantMedicineService service;

    public PlantMedicineController(PlantMedicineService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlantMedicine> getAll() {
        return service.getAllRelations();
    }

    @PostMapping
    public PlantMedicine add(@RequestBody PlantMedicine relation) {
        return service.saveRelation(relation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRelation(id);
    }
}
