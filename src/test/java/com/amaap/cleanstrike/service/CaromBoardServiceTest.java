package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.CaromBoardRepository;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CaromBoardServiceTest {

    PlayerService playerService = new PlayerService(new PlayerRepository(new FakeInMemoryDatabase()));
    CaromBoardService caromBoardService = new CaromBoardService(new CaromBoardRepository(new FakeInMemoryDatabase()), playerService);

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
    void shouldBeAbleToGetWinnerOfTheGame() throws InvalidArgumentException {
        // arrange
        caromBoardService.create(9, 1);
        CaromBoard board = caromBoardService.getBoard(1);
        boolean result = playerService.createPlayer(new GameRuleManager());
        playerService.createPlayer(new GameRuleManager());
        playerService.createPlayer(new GameRuleManager());

        //act
        caromBoardService.getWinner(board);


    }


}