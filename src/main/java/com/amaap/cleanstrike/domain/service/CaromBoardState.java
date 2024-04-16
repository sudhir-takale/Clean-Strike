package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.Board;

public interface CaromBoardState {

    void applyStrike(Board board, int player);

}
