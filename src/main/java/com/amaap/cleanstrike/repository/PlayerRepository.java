package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;

import java.util.List;

public class PlayerRepository {
    private FakeInMemoryDatabase database;

    public PlayerRepository(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public void save(Player player) {
        database.save(player);
    }

    public List<Player> getPlayers() {
        return database.getPlayers();
    }
}
