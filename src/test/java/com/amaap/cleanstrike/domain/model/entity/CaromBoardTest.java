package com.amaap.cleanstrike.domain.model.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class CaromBoardTest {

    @Test
    void shouldCreateCaromBoardWithValidArguments() {
        // arrange
        int blackCoins = 9;
        int redCoins = 1;

        // act
        CaromBoard caromBoard = new CaromBoard(blackCoins, redCoins);

        // assert
        assertEquals(blackCoins, caromBoard.getBlackCoins());
        assertEquals(redCoins, caromBoard.getRedCoins());
    }
    @Test
    void shouldThrowExceptionWhenInvalidArgumentsPassed() {
        // arrange
        int blackCoins = -1;
        int redCoins = 3;

        // assert
        assertThrows(IllegalArgumentException.class, () -> new CaromBoard(blackCoins, redCoins));
    }
    @Test
    void shouldBeAbleGetAndSetId() {
        // arrange
        CaromBoard caromBoard = new CaromBoard(9, 1);
        int id = 123;

        // act
        caromBoard.setId(id);

        // assert
        assertEquals(id, caromBoard.getId());
    }
    @Test
    void shouldGetAndSetBlackCoins() {
        // arrange
        CaromBoard caromBoard = new CaromBoard(9, 1);
        int blackCoins = 6;

        // act
        caromBoard.setBlackCoins(blackCoins);

        // assert
        assertEquals(blackCoins, caromBoard.getBlackCoins());
    }

    @Test
    void shouldGetAndSetRedCoins() {
        // arrange
        CaromBoard caromBoard = new CaromBoard(9, 1);
        int redCoins = 5;

        // act
        caromBoard.setRedCoins(redCoins);

        // assert
        assertEquals(redCoins, caromBoard.getRedCoins());
    }

    @Test
    void shouldGetAndSetPlayers() {
        // arrange
        CaromBoard caromBoard = new CaromBoard(9, 1);
        List<Player> players = new ArrayList<>();
        players.add(new Player());

        // act
        caromBoard.setPlayers(players);

        // assert
        assertEquals(players, caromBoard.getPlayers());
    }

}