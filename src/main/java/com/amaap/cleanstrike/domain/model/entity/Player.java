package com.amaap.cleanstrike.domain.model.entity;

import com.amaap.cleanstrike.domain.model.valueobject.FoulStrikeManager;

public class Player {
    private int id;
    private FoulStrikeManager ruleManager;
    private int points;
    private String lastStrike;

    public Player() {
        ruleManager = new FoulStrikeManager();
        this.points = 0;
        lastStrike = " ";
    }

    public String getLastStrike() {
        return lastStrike;
    }

    public void setLastStrike(String lastStrike) {
        this.lastStrike = lastStrike;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public FoulStrikeManager getRuleManager() {
        return ruleManager;
    }

}
