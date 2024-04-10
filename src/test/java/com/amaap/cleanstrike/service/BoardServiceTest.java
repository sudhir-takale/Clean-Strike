package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.repository.BoardRepository;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardServiceTest {

    BoardService boardService = new BoardService(new BoardRepository(new FakeInMemoryDatabase()),
            new PlayerService(new PlayerRepository(new FakeInMemoryDatabase())));

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
        //act
        String winner = boardService.getWinner(board);


    }


}