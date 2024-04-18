package com.amaap.cleanstrike.domain.model.entity;

import java.util.List;

public class CaromBoard {

    private int id;
    private int blackCoins;
    private int redCoins;
    private List<Player> players;

    public CaromBoard(int blackCoins, int redCoin) {
        this.blackCoins = blackCoins;
        this.redCoins = redCoin;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlackCoins() {
        return blackCoins;
    }

    public void setBlackCoins(int coin) {
        this.blackCoins = coin;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getRedCoins() {
        return redCoins;
    }

    public void setRedCoins(int coins) {
        this.redCoins = coins;
    }
}
