package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.Board;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardRepositoryTest {

    BoardRepository boardRepository = new BoardRepository(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToSaveTheCaromBoard() {
        // arrange
        Board board = new Board(9, 1);

        // act
        int result = boardRepository.save(board);

        // assert
        Assertions.assertEquals(1, result);

    }

    @Test
    void shouldBeAbleToGetTheCaromBoardForAnId() {
        // arrange
        int id = 1;
        Board expected = new Board(9, 1);
        boardRepository.save(expected);
        // act
        Board actual = boardRepository.getBoard(id);

        // assert
        Assertions.assertEquals(1, actual.getId());

    }

}