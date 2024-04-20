package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.PlayerRepository;

import com.google.inject.Inject;

import java.util.List;
import java.util.Random;

public class PlayerService {

    private final PlayerRepository playerRepository;

    @Inject
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean createPlayer(GameRuleManager ruleManager) {

        if (ruleManager == null) throw new NullPointerException("GameRuleManager is null");

        Player player = new Player();
        playerRepository.save(player);
        return true;
    }

    public List<Player> getPlayer() {
        return playerRepository.getPlayers();
    }

    public int getRandomIndex(int maxLimit) {
        Random random = new Random();
        return random.nextInt(maxLimit);
    }
}
