package com.cricket.cricket_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cricket.cricket_management.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}