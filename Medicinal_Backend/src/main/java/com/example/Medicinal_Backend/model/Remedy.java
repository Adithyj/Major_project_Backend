package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Remedy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category; // e.g., Herbal Tea, Decoction
    private String remedyName;

    @Column(length = 1000)
    private String disease;

    @Column(length = 1000)
    private String symptoms;

    @Column(length = 4000)
    private String preparationMethod;

    @Column(length = 1000)
    private String dosage;

    @Column(length = 1000)
    private String precautions;

    @Column(length = 4000)
    private String scientificExplanation;

    private String referenceSource;

    @ManyToMany
    @JoinTable(
        name = "remedy_plants",
        joinColumns = @JoinColumn(name = "remedy_id"),
        inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private List<Plant> plants;
}