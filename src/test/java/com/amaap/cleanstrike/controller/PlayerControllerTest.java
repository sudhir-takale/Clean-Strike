package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.valueobject.FoulStrikeManager;
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
        FoulStrikeManager ruleManager = new FoulStrikeManager();
        Response expected = new Response(HttpStatus.OK,"Players created successfully" );

        //act
        Response actual = playerController.createPlayer();

        //assert
        Assertions.assertEquals(expected, actual);

    }


}
