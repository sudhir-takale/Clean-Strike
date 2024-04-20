package com.amaap.cleanstrike.domain.model.entity;

import java.util.List;

import static com.amaap.cleanstrike.domain.model.entity.validator.CaromBoardValidator.validate;

public class CaromBoard {

    private int id;
    private int blackCoins;
    private int redCoins;
    private List<Player> players;

    public CaromBoard(int blackCoins, int redCoin) {
        if (!validate(blackCoins, redCoin)) {
            throw new IllegalArgumentException("Invalid arguments passed");
        }

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
