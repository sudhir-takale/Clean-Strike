package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.PlayerRepository;

import java.util.List;

public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean createPlayer(GameRuleManager ruleManager) {

        if (ruleManager == null) throw new NullPointerException("GameRuleManager is null");

        Player player = new Player(ruleManager);
        playerRepository.save(player);
        return true;
    }

    public List<Player> getPlayer() {
        return playerRepository.getPlayers();
    }
}
