package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;

public class BoardRepository {
    private FakeInMemoryDatabase database;

    public BoardRepository(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public void save(Board board) {
        database.save(board);
    }

    public Board getBoard(int i) {
        return database.getBoard(i);
    }
}
