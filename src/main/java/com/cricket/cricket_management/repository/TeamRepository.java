package com.cricket.cricket_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.cricket_management.model.Team;

@Repository
public interface TeamRepository
        extends JpaRepository<Team, Long> {

    // SEARCH by team name
    List<Team> findByTeamNameContainingIgnoreCase(
            String teamName);
}