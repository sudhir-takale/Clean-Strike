package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.service.PlayerService;
import com.google.inject.Inject;


public class PlayerController {

    private PlayerService playerService;

    @Inject
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response createPlayer() {
        playerService.createPlayer();
        return new Response(HttpStatus.OK, "Players created successfully");
    }


}
