package com.example.Medicinal_Backend.repository;

import com.example.Medicinal_Backend.model.UserLearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLearningProgressRepository extends JpaRepository<UserLearningProgress, Long> {
}