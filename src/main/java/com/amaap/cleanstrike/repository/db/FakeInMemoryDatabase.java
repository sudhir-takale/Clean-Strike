package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.Player;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase {
    private int playerId = 0;
    private final List<Player> players = new ArrayList<>();

    public void save(Player player, Player player1) {
        playerId++;
        player.setId(playerId);
        playerId++;
        player1.setId(playerId);
        players.add(player);
        players.add(player1);
    }


    public List<Player> getPlayers() {
        return this.players;
    }
}
