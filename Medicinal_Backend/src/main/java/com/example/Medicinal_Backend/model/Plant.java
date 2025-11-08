package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     int a;
    private String plantName;
    private String scientificName;
    private String family;
    private String leafName;
    private String imageUrl;
    private String region;
    private String leafType;
    private String flowerColor;
    private String height;

    @Column(length = 2000)
    private String growthConditions;

    @Column(length = 2000)
    private String uses;

    @Column(length = 1000)
    private String toxicity;

    @Column(length = 4000)
    private String description;

    // Relationships
    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<PlantSymptom> symptoms;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;

	public String getPlantName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
