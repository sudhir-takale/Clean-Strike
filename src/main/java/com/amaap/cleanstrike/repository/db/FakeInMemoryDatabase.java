package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.entity.Board;
import com.amaap.cleanstrike.domain.model.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase {
    private final List<Player> players = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();
    private int playerId = 0;

    public void save(Player player, Player player1) {
        playerId++;
        player.setId(playerId);
        playerId++;
        player1.setId(playerId);
        players.add(player);
        players.add(player1);
    }

    public List<Player> getPlayers() {
        System.out.println(players);
        return this.players;
    }

    public void save(Board board) {
        boards.add(board);
    }

    public Board getBoard(int id) {
        return boards.get(0);
    }
}
