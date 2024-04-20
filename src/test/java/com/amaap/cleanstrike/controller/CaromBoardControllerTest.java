package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.impl.CaromBoardRepositoryImpl;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.service.CaromBoardService;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaromBoardControllerTest {

    BoardController boardController =
            new BoardController(new CaromBoardService(new CaromBoardRepositoryImpl(new FakeInMemoryDatabaseImpl()),
                    new PlayerService(new PlayerRepositoryImpl(new FakeInMemoryDatabaseImpl()))));

    @Test
    void shouldBeAbleToCreateBoard() {
        //arrange
        Response expected = new Response(HttpStatus.OK, "success");
        //act
        Response actual = boardController.createBoard(9, 1);
        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBadResponseWhenInvalidArgumentPassed() {
        // arrange
        Response expected = new Response(HttpStatus.BADREQUEST, "Check your arguments");

        // act
        Response actual = boardController.createBoard(0, 4);
        Response actual1 = boardController.createBoard(1, 0);
        Response actual2 = boardController.createBoard(4, 4);
        Response actual3 = boardController.createBoard(-12, 4);
        Response actual4 = boardController.createBoard(-12, -3);

        // assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected, actual1);
        Assertions.assertEquals(expected, actual2);
        Assertions.assertEquals(expected, actual3);
        Assertions.assertEquals(expected, actual4);
    }



}
