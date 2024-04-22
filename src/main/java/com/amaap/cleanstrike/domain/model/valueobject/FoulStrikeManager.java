package com.amaap.cleanstrike.domain.model.valueobject;

public class FoulStrikeManager {
    private int foulCount;
    private int nonStrikeCount;

    public FoulStrikeManager() {
        this.nonStrikeCount = 0;
        this.foulCount = 0;
    }

    public int getNonStrikeCount() {
        return nonStrikeCount;
    }

    public void setNonStrikeCount(int nonStrikeCount) {
        this.nonStrikeCount = nonStrikeCount;
    }

    public int getFoulCount() {
        return foulCount;
    }

    public void setFoulCount(int foulCount) {
        this.foulCount = foulCount;
    }
}
