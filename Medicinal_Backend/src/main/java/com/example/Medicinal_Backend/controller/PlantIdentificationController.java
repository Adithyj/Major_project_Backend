package com.example.Medicinal_Backend.controller;

import com.example.Medicinal_Backend.model.Plant;
import com.example.Medicinal_Backend.repository.PlantRepository;
import com.example.Medicinal_Backend.service.VisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin("*")
public class PlantIdentificationController {

    @Autowired
    private VisionService visionService;

    @Autowired
    private PlantRepository plantRepository;

    @PostMapping("/identify")
    public ResponseEntity<?> identifyPlant(@RequestParam("image") MultipartFile file) {
        try {
            List<String> detectedLabels = visionService.detectLabels(file.getBytes());
            if (detectedLabels.isEmpty()) {
                return ResponseEntity.ok(Collections.singletonMap("message", "No plant detected."));
            }

            // Find matching plants in DB (case-insensitive partial match)
            List<Plant> matchedPlants = plantRepository.findAll().stream()
                    .filter(p -> detectedLabels.stream()
                            .anyMatch(label -> label.toLowerCase().contains(p.getPlantName().toLowerCase())
                                    || p.getPlantName().toLowerCase().contains(label.toLowerCase())))
                    .toList();

            if (matchedPlants.isEmpty()) {
                return ResponseEntity.ok(Collections.singletonMap("message", "No matching plants found in database."));
            }

            return ResponseEntity.ok(matchedPlants);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error identifying plant: " + e.getMessage());
        }
    }
}

