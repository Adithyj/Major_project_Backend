package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "plant_medicine")
public class PlantMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
}
