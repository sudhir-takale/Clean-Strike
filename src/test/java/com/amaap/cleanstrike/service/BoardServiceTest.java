package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.BoardRepository;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardServiceTest {

    PlayerService playerService = new PlayerService(new PlayerRepository(new FakeInMemoryDatabase()));
    BoardService boardService = new BoardService(new BoardRepository(new FakeInMemoryDatabase()),playerService);

    @Test
    void shouldBeAbleToCreateCaromBoardWithInitialValues() throws InvalidArgumentException {
        // act
        boolean result = boardService.create(9, 1);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldThrowExceptionIfInvalidCountOfCoinsIsPassed() {
        //assert
        assertThrows(InvalidArgumentException.class, () -> boardService.create(1, 0));
    }





    @Test
    void shouldBeAbleToGetWinnerOfTheGame() throws InvalidArgumentException {
        //act
        boardService.create(9, 1);
        Board board = boardService.getBoard(1);
        boolean result = playerService.createPlayers(new GameRuleManager());
        System.out.println(result);
        //act
         boardService.getWinner(board);


    }


}