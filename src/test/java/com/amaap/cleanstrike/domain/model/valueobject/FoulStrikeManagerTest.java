package com.amaap.cleanstrike.domain.model.valueobject;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class FoulStrikeManagerTest {
    @Test
    void shouldInitializeFailCountToZero() {
        // arrange & act
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();

        // assert
        assertEquals(0, foulStrikeManager.getNonStrikeCount());
    }

    @Test
    void shouldInitializeFoulCountToZero() {
        // arrange & act
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();

        // assert
        assertEquals(0, foulStrikeManager.getFoulCount());
    }

    @Test
    void shouldBeAbleSetAndGetFailCount() {
        // arrange
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();
        int failCount = 2;

        // act
        foulStrikeManager.setNonStrikeCount(failCount);

        // assert
        assertEquals(failCount, foulStrikeManager.getNonStrikeCount());
    }

    @Test
    void shouldBeAbleSetAndGetFoulCount() {
        // arrange
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();
        int foulCount = 3;

        // act
        foulStrikeManager.setFoulCount(foulCount);

        // assert
        assertEquals(foulCount, foulStrikeManager.getFoulCount());
    }

    @Test
    void shouldBeAbleToGetFoulCount(){
        // arrange
        FoulStrikeManager foulStrikeManager = new FoulStrikeManager();
        int foulCount = 3;
        int failCount = 3;

        // act
        foulStrikeManager.setFoulCount(foulCount);
        foulStrikeManager.setNonStrikeCount(3);

        // assert
        assertEquals(3, foulStrikeManager.getFoulCount());
        assertEquals(3, foulStrikeManager.getNonStrikeCount());
    }


}