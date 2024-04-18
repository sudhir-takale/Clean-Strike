package com.amaap.cleanstrike.domain.model.entity;

import com.amaap.cleanstrike.domain.model.valueobject.GameRuleManager;

public class Player {
    private int id;
    private GameRuleManager ruleManager;
    private int points;


    public Player(GameRuleManager ruleManager) {
        this.ruleManager = ruleManager;
        this.points = 0;
    }

    public int getId() {
        return this.id;
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

    public GameRuleManager getRuleManager() {
        return ruleManager;
    }

    public void setRuleManager(GameRuleManager ruleManager) {
        this.ruleManager = ruleManager;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", ruleManager=" + ruleManager +
                ", points=" + points +
                '}';
    }
}