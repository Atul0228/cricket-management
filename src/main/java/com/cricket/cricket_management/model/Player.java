package com.cricket.cricket_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    private String playerName;

    private String role;

    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}