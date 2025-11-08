package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;
    private String symptom;
    
    @Column(length = 2000)
    private String preparationMethod;

    @Column(length = 500)
    private String dosage;

    // Many-to-many relationship with Plant
    @ManyToMany
    @JoinTable(
        name = "plant_medicine",
        joinColumns = @JoinColumn(name = "medicine_id"),
        inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private List<Plant> plants;
}
