package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.Remedy;
import com.example.Medicinal_Backend.service.RemedyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remedies")
@CrossOrigin(origins = "*")
public class RemedyController {

    private final RemedyService service;

    public RemedyController(RemedyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Remedy> getAll() {
        return service.getAllRemedies();
    }

    @GetMapping("/{id}")
    public Remedy getById(@PathVariable Long id) {
        return service.getRemedyById(id).orElse(null);
    }

    @PostMapping
    public Remedy add(@RequestBody Remedy remedy) {
        return service.saveRemedy(remedy);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRemedy(id);
    }
}
