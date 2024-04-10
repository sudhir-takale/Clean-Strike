package com.amaap.cleanstrike.domain.model;

public class Player {
   private int id;
    private GameRuleManager ruleManager;
    private int points;

    public Player(GameRuleManager ruleManager) {
        this.ruleManager = ruleManager;
        this.points = 0;
    }

}
