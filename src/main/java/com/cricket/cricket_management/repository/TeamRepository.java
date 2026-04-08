package com.cricket.cricket_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cricket.cricket_management.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}