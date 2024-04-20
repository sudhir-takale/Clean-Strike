package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.google.inject.Singleton;


import java.util.ArrayList;
import java.util.List;

@Singleton
public class FakeInMemoryDatabaseImpl implements FakeInMemoryDatabase {
    private final List<Player> players = new ArrayList<>();
    private final List<CaromBoard> boards = new ArrayList<>();
    private int playerId = 0;
    private int boardId = 0;

    public void save(Player player) {
        playerId++;
        player.setId(playerId);
        players.add(player);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int add(CaromBoard board) {
        boardId++;
        boards.add(board);
        board.setId(boardId);
        return 1;
    }

    public CaromBoard getBoard(int id) {
        CaromBoard board1 = null;
        for (CaromBoard board : boards) {
            if (board.getId() == id) board1 = board;
        }

        return board1;
    }

}
