package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.google.inject.Singleton;

import java.util.List;

public interface FakeInMemoryDatabase {

    void save(Player player);

    List<Player> getPlayers();

    int add(CaromBoard board);

    CaromBoard getBoard(int id);
}
