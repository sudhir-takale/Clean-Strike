package com.amaap.cleanstrike;

import com.amaap.cleanstrike.controller.PlayerController;
import com.amaap.cleanstrike.domain.model.GameRuleManager;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerControllerTest {


    PlayerController playerController = new PlayerController(new PlayerService(new PlayerRepository(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToCreateTwoPlayers() {
        //arrange
        GameRuleManager ruleManager = new GameRuleManager();
        //act
        boolean result = playerController.createPlayers(ruleManager);
        //assert
        Assertions.assertTrue(result);

    }


}
