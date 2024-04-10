package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.service.BoardService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BoardControllerTest {

    BoardController boardController = new BoardController(new BoardService());

    @Test
    void shouldBeAbleToCreateBoard() {
        //arrange
        Response expected = new Response(HttpStatus.OK, "success");
        //act
        Response actual = boardController.createBoard(9, 1);
        //assert
        assertEquals(expected, actual);

    }


}
