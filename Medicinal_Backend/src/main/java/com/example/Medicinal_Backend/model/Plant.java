package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plantName;
    private String scientificName;
    private String family;
    private String region;
    private String description;
    private String uses;
    private String imageUrl;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<PlantSymptom> symptoms;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;

    // ✅ All getters and setters (important)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlantName() { return plantName; }
    public void setPlantName(String plantName) { this.plantName = plantName; }

    public String getScientificName() { return scientificName; }
    public void setScientificName(String scientificName) { this.scientificName = scientificName; }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUses() { return uses; }
    public void setUses(String uses) { this.uses = uses; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
