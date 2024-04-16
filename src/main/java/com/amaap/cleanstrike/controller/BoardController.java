package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.service.BoardService;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;

public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    public Response createBoard(int blackCoins, int redCoin) {
        try {
            boardService.create(blackCoins, redCoin);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidArgumentException e) {
            return new Response(HttpStatus.BADREQUEST, "Check your arguments");
        }
    }




}
