package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @Column(length = 1000)
    private String question;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private char correctOption;
}

