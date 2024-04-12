package com.amaap.cleanstrike.domain.model.valueobject;

public class GameRuleManager {
    private int foulCount;
    private int failCount;

    public GameRuleManager() {
        this.failCount = 0;
        this.foulCount = 0;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public int getFoulCount() {
        return foulCount;
    }

    public void setFoulCount(int foulCount) {
        this.foulCount = foulCount;
    }
}
