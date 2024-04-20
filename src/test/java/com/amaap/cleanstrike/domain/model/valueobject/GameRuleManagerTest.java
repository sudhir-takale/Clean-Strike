package com.amaap.cleanstrike.domain.model.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class GameRuleManagerTest {
    @Test
    void shouldInitializeFailCountToZero() {
        // arrange & act
        GameRuleManager gameRuleManager = new GameRuleManager();

        // assert
        assertEquals(0, gameRuleManager.getFailCount());
    }

    @Test
    void shouldInitializeFoulCountToZero() {
        // arrange & act
        GameRuleManager gameRuleManager = new GameRuleManager();

        // assert
        assertEquals(0, gameRuleManager.getFoulCount());
    }

    @Test
    void shouldBeAbleSetAndGetFailCount() {
        // arrange
        GameRuleManager gameRuleManager = new GameRuleManager();
        int failCount = 2;

        // act
        gameRuleManager.setFailCount(failCount);

        // assert
        assertEquals(failCount, gameRuleManager.getFailCount());
    }

    @Test
    void shouldBeAbleSetAndGetFoulCount() {
        // arrange
        GameRuleManager gameRuleManager = new GameRuleManager();
        int foulCount = 3;

        // act
        gameRuleManager.setFoulCount(foulCount);

        // assert
        assertEquals(foulCount, gameRuleManager.getFoulCount());
    }

    @Test
    void shouldBeAbleToGetFoulCount(){
        // arrange
        GameRuleManager gameRuleManager = new GameRuleManager();
        int foulCount = 3;
        int failCount = 3;

        // act
        gameRuleManager.setFoulCount(foulCount);
        gameRuleManager.setFailCount(3);

        // assert
        assertEquals(3, gameRuleManager.getFoulCount());
        assertEquals(3, gameRuleManager.getFailCount());
    }


}