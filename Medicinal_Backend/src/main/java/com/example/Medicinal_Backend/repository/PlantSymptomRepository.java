package com.example.Medicinal_Backend.repository;

import com.example.Medicinal_Backend.model.PlantSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSymptomRepository extends JpaRepository<PlantSymptom, Long> {
}

