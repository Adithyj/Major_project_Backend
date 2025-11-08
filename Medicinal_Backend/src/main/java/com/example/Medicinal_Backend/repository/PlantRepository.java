package com.example.Medicinal_Backend.repository;

import com.example.Medicinal_Backend.model.Plant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
	 List<Plant> findByPlantNameIn(List<String> plantNames);
}
