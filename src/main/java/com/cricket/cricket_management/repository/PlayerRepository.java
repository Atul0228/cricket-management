package com.cricket.cricket_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cricket.cricket_management.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}