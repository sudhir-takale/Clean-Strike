package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.service.PlayerService;
import com.google.inject.Inject;


public class PlayerController {

    private PlayerService playerService;

    @Inject
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response createPlayer(GameRuleManager ruleManager) {
        playerService.createPlayer(ruleManager);
        return new Response(HttpStatus.OK, "Players created successfully");
    }


}
