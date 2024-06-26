package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.repository.impl.CaromBoardRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaromBoardRepositoryTest {

    CaromBoardRepository caromBoardRepository = new CaromBoardRepositoryImpl(new FakeInMemoryDatabaseImpl());

    @Test
    void shouldBeAbleToSaveTheCaromBoard() {
        // arrange
        CaromBoard board = new CaromBoard(9, 1);

        // act
        int result = caromBoardRepository.save(board);

        // assert
        Assertions.assertEquals(1, result);

    }

    @Test
    void shouldBeAbleToGetTheCaromBoardForAnId() {
        // arrange
        int id = 1;
        CaromBoard expected = new CaromBoard(9, 1);
        caromBoardRepository.save(expected);
        // act
        CaromBoard actual = caromBoardRepository.getBoard(id);

        // assert
        Assertions.assertEquals(1, actual.getId());

    }

}