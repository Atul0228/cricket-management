package com.cricket.cricket_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.cricket_management.model.Player;
import com.cricket.cricket_management.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}