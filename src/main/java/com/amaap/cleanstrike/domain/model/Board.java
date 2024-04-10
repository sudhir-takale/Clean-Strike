package com.amaap.cleanstrike.domain.model;

import java.util.List;

public class Board {
    private final int blackCoins;
    private final int redCoins;
    private int id;
    private List<Player> players;

    public Board(int blackCoins, int redCoin) {
        this.blackCoins = blackCoins;
        this.redCoins = redCoin;
    }

    public void assignPlayers(List<Player> playerList) {
        this.players = playerList;
    }

    public int getId() {
        return this.id;
    }
}
