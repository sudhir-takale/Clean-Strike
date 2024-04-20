package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerServiceTest {

    PlayerService playerService = new PlayerService(new PlayerRepositoryImpl(new FakeInMemoryDatabaseImpl()));

    @Test
    void shouldBeAbleToCreatePlayer() {
        //arrange
        GameRuleManager gameRuleManager = new GameRuleManager();

        //act
        boolean result = playerService.createPlayer(gameRuleManager);

        //assert
        assertTrue(result);
    }

    @Test
    void shouldThrowExceptionWhenRuleManagerIsNull() {
        //arrange
        GameRuleManager ruleManager = null;

        //assert
        assertThrows(NullPointerException.class, () -> playerService.createPlayer(null));
    }

    @Test
    void shouldReturnListOfTwoPlayers() {
        //arrange
        GameRuleManager gameRuleManager = new GameRuleManager();
        playerService.createPlayer(gameRuleManager);
        playerService.createPlayer(gameRuleManager);

        //act
        List<Player> playerList = playerService.getPlayer();

        //assert
        assertEquals(2, playerList.size());
    }
    @Test
    void shouldReturnRandomIndexWithinMaxLimit() {
        // arrange
        int maxLimit = 10;

        // act
        int randomIndex = playerService.getRandomIndex(maxLimit);

        // assert
        assertTrue(randomIndex >= 0 && randomIndex < maxLimit);
    }
}