package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.Medicine;
import com.example.Medicinal_Backend.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin(origins = "*")
public class MedicineController {

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medicine> getAll() {
        return service.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getById(@PathVariable Long id) {
        return service.getMedicineById(id).orElse(null);
    }

    @PostMapping
    public Medicine add(@RequestBody Medicine medicine) {
        return service.saveMedicine(medicine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteMedicine(id);
    }
}

