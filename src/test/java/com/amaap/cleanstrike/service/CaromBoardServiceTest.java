package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.repository.impl.CaromBoardRepositoryImpl;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CaromBoardServiceTest {

    PlayerService playerService = new PlayerService(new PlayerRepositoryImpl(new FakeInMemoryDatabaseImpl()));
    CaromBoardService caromBoardService =
            new CaromBoardService(new CaromBoardRepositoryImpl(new FakeInMemoryDatabaseImpl())
                    , playerService);

    @Test
    void shouldBeAbleToCreateCaromBoardWithInitialValues() throws InvalidArgumentException {
        // act
        boolean result = caromBoardService.create(9, 1);

        //assert
        assertTrue(result);
    }

    @Test
    void shouldThrowExceptionIfInvalidCountOfCoinsIsPassed() {
        //assert
        assertThrows(InvalidArgumentException.class, () -> caromBoardService.create(1, 0));
    }

    @Test
    void shouldBeAbleToGetExistingBoard() throws InvalidArgumentException {
        // arrange
        int expectedBlackCoins = 9;
        int expectedRedCoins = 1;

        // act
        caromBoardService.create(9, 1);
        CaromBoard board = caromBoardService.getBoard(1);

        // assert
        assertNotNull(board);
        assertEquals(expectedBlackCoins, board.getBlackCoins());
        assertEquals(expectedRedCoins, board.getRedCoins());
    }

    @Test
    void shouldReturnWinnerWhenGameIsCompleted() throws InvalidArgumentException {
        // arrange
        caromBoardService.create(9, 1);
        playerService.createPlayer(new GameRuleManager());
        playerService.createPlayer(new GameRuleManager());

        // act
        String winner = caromBoardService.getWinner();

        // assert
        assertNotNull(winner);
        assertFalse(winner.isEmpty());
    }


}