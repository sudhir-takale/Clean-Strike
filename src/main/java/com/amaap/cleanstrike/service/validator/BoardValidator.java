package com.amaap.cleanstrike.service.validator;

public class BoardValidator {
    public static boolean validate(int blackCoins, int redCoin) {
        return (blackCoins <= 0 || redCoin <= 0) || (blackCoins != 9 && redCoin != 1);
    }
}
