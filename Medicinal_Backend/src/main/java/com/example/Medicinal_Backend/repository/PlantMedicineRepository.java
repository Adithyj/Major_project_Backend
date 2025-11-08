package com.example.Medicinal_Backend.repository;

import com.example.Medicinal_Backend.model.PlantMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantMedicineRepository extends JpaRepository<PlantMedicine, Long> {
}

