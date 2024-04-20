package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private final FakeInMemoryDatabase database;

    @Inject
    public PlayerRepositoryImpl(FakeInMemoryDatabase database) {
        this.database = database;
    }

    public void save(Player player) {
        database.save(player);
    }

    public List<Player> getPlayers() {
        return database.getPlayers();
    }
}
