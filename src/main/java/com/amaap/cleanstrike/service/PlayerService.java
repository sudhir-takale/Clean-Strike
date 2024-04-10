package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.GameRuleManager;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;

public class PlayerService {
    private PlayerRepository playerRepository;


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
}
