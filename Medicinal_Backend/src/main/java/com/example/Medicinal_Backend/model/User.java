package com.example.Medicinal_Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "users") // 'user' is a reserved keyword in SQL
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role; // student/admin

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserQuizProgress> quizProgressList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserLearningProgress> learningProgressList;
}

