package com.amaap.cleanstrike.service.exception;

public class InvalidArgumentException extends Throwable {
    public InvalidArgumentException(String checkYourCoins) {
        super(checkYourCoins);
    }
}
