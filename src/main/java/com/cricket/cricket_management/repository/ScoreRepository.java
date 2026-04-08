package com.cricket.cricket_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cricket.cricket_management.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}