package com.amaap.cleanstrike.domain.model.entity.validator;

public class CaromBoardValidator {
    public static boolean validate(int blackCoins, int redCoin) {
        return (blackCoins == 9 && redCoin == 1);
    }
}
