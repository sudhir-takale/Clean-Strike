package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerControllerTest {


    PlayerController playerController =
            new PlayerController(new PlayerService(new PlayerRepositoryImpl(new FakeInMemoryDatabaseImpl())));

    @Test
    void shouldBeAbleToCreateTwoPlayers() {
        //arrange
        GameRuleManager ruleManager = new GameRuleManager();
        Response expected = new Response(HttpStatus.OK,"Players created successfully" );

        //act
        Response actual = playerController.createPlayer(ruleManager);

        //assert
        Assertions.assertEquals(expected, actual);

    }


}
