package com.amaap.cleanstrike.domain.service.outcomeprocesses;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;

public class RedStrikeProcessor implements CaromBoardState {

    @Override
    public void applyStrike(CaromBoard board, Player player) {
        player.setPoints(player.getPoints() + 3);
        board.setRedCoins(0);
        player.setLastStrike("redstrike");

    }
}
