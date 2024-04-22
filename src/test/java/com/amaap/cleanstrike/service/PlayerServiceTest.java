package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.model.valueobject.FoulStrikeManager;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerServiceTest {

    PlayerService playerService = new PlayerService(new PlayerRepositoryImpl(new FakeInMemoryDatabaseImpl()));

    @Test
    void shouldBeAbleToCreatePlayer() {
        //arrange
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();

        //act
        boolean result = playerService.createPlayer();

        //assert
        assertTrue(result);
    }

   
    @Test
    void shouldReturnListOfTwoPlayers() {
        //arrange
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();
        playerService.createPlayer();
        playerService.createPlayer();

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