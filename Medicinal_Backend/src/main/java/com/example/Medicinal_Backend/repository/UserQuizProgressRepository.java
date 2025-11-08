package com.example.Medicinal_Backend.repository;

import com.example.Medicinal_Backend.model.UserQuizProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQuizProgressRepository extends JpaRepository<UserQuizProgress, Long> {
}
