package com.amaap.cleanstrike;

import com.amaap.cleanstrike.controller.service.GameService;
import com.amaap.cleanstrike.domain.model.GameRuleManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerControllerTest {


    PlayerController playerController = new PlayerController(new GameService());

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
