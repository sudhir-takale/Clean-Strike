package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;

import java.util.Collection;
import java.util.List;

public class PlayerRepository {
    private FakeInMemoryDatabase database;

    public PlayerRepository(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public void save(Player player, Player player1) {
        database.save(player, player1);
    }

    public List<Player> getPlayers() {
        return database.getPlayers();
    }
}
