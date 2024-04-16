package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.entity.Board;
import com.amaap.cleanstrike.domain.model.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase {
    private final List<Player> players = new ArrayList<>();
    private final List<Board> boards = new ArrayList<>();
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

    public int add(Board board) {
        boardId++;
        boards.add(board);
        board.setId(boardId);
        return 1;
    }

    public Board getBoard(int id) {
        Board board1 = null;
        for (Board board : boards) {
            if (board.getId() == id) board1 = board;
        }

        return board1;
    }

}
