package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;

public interface CaromBoardState {

    void applyStrike(CaromBoard board, Player player);

}
