package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.valueobject.FoulStrikeManager;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryTest {

    PlayerRepository playerRepository = new PlayerRepositoryImpl(new FakeInMemoryDatabaseImpl());
    @Test
    void shouldBeAbleToAddPlayerInDatabase() {
        //arrange
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();

        //act
        playerRepository.save(new Player());
        playerRepository.save(new Player());

        //assert
        assertEquals(2, playerRepository.getPlayers().size());
    }

}