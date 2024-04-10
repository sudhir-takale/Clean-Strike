package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.GameRuleManager;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerServiceTest {

    PlayerService playerService = new PlayerService(new PlayerRepository(new FakeInMemoryDatabase()));

    @Test
    void shouldBeAbleToCreateTwoPlayers() {
        //arrange
        GameRuleManager gameRuleManager = new GameRuleManager();
        //act
        boolean result = playerService.createPlayers(gameRuleManager);
        //assert
        assertTrue(result);
    }

    @Test
    void shouldThrowExceptionWhenRuleManagerIsNull() {
        //arrange
        GameRuleManager ruleManager = null;
        //assert
        assertThrows(NullPointerException.class, () -> playerService.createPlayers(ruleManager));
    }

}