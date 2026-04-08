package com.cricket.cricket_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String teamName;

    private String coach;

    @OneToMany(mappedBy = "team",
               cascade = CascadeType.ALL)
    private List<Player> players;
}