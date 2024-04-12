package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.Player;

public interface CaromBoardState {

    void applyStrike(Board board, int player);

}
