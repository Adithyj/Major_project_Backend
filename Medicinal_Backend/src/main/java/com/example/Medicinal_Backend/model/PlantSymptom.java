package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PlantSymptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symptom;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
}
