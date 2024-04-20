package com.amaap.cleanstrike.service.validator;

public class BoardValidator {
    public static boolean validate(int blackCoins, int redCoin) {
        return (blackCoins == 9 && redCoin == 1);
    }
}
