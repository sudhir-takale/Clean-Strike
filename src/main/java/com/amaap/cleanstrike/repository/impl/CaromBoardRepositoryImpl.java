package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.repository.CaromBoardRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.google.inject.Inject;

public class CaromBoardRepositoryImpl implements CaromBoardRepository {
    private final FakeInMemoryDatabase database;

    @Inject
    public CaromBoardRepositoryImpl(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public int save(CaromBoard board) {
        return database.add(board);
    }

    public CaromBoard getBoard(int i) {
        return database.getBoard(i);
    }
}
