package com.example.Medicinal_Backend.repository;

import com.example.Medicinal_Backend.model.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedyRepository extends JpaRepository<Remedy, Long> {
}
