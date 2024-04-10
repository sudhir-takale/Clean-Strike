package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.domain.model.GameRuleManager;



public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public boolean createPlayers(GameRuleManager ruleManager) {
        playerService.createPlayers(ruleManager);
//        return new Response(https.ok,"Players created Successfully");
        return true;
    }
}
