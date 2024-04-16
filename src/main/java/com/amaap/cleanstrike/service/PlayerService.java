package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;

import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean createPlayers(GameRuleManager ruleManager) {

        if (ruleManager == null) throw new NullPointerException("GameRuleManager is null");

        Player player = new Player(ruleManager);
        Player player1 = new Player(ruleManager);
        playerRepository.save(player, player1);
        return true;
    }

    public List<Player> getPlayers() {
        return playerRepository.getPlayers();
    }
}
