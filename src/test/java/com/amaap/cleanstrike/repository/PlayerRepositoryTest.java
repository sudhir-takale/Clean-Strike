package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryTest {

    PlayerRepository playerRepository = new PlayerRepository(new FakeInMemoryDatabase());
    @Test
    void shouldBeAbleToAddPlayerInDatabase() {
        //arrange
        GameRuleManager gameRuleManager = new GameRuleManager();

        //act
        playerRepository.save(new Player(gameRuleManager));
        playerRepository.save(new Player(gameRuleManager));

        //assert
        assertEquals(2, playerRepository.getPlayers().size());
    }

}