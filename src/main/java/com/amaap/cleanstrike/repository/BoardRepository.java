package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.Board;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;

public class BoardRepository {
    private final FakeInMemoryDatabase database;

    public BoardRepository(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public int save(Board board) {
        return database.add(board);
    }

    public Board getBoard(int i) {
        return database.getBoard(i);
    }
}
