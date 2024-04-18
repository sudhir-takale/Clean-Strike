package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;

public class CaromBoardRepository {
    private final FakeInMemoryDatabase database;

    public CaromBoardRepository(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public int save(CaromBoard board) {
        return database.add(board);
    }

    public CaromBoard getBoard(int i) {
        return database.getBoard(i);
    }
}
