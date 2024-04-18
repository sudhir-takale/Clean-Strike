package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.service.CaromBoardService;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;

public class BoardController {
    private final CaromBoardService caromBoardService;

    public BoardController(CaromBoardService caromBoardService) {
        this.caromBoardService = caromBoardService;
    }

    public Response createBoard(int blackCoins, int redCoin) {
        try {
            caromBoardService.create(blackCoins, redCoin);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidArgumentException e) {
            return new Response(HttpStatus.BADREQUEST, "Check your arguments");
        }
    }




}
