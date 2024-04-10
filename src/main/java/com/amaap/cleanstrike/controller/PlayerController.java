package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.GameRuleManager;
import com.amaap.cleanstrike.service.PlayerService;


public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response createPlayers(GameRuleManager ruleManager) {
        playerService.createPlayers(ruleManager);
        return new Response(HttpStatus.OK, "Players created successfully");
    }
}
