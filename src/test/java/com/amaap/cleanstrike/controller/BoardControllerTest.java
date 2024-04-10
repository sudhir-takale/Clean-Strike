package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.BoardRepository;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.BoardService;
import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BoardControllerTest {

    BoardController boardController = new BoardController(new BoardService(new BoardRepository(new FakeInMemoryDatabase()),
            new PlayerService(new PlayerRepository(new FakeInMemoryDatabase()))));

    @Test
    void shouldBeAbleToCreateBoard() throws InvalidArgumentException {
        //arrange
        Response expected = new Response(HttpStatus.OK, "success");
        //act
        Response actual = boardController.createBoard(9, 1);
        //assert
        assertEquals(expected, actual);
    }


}
