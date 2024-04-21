package com.amaap.cleanstrike.domain.service.outcomeprocesses;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;


public class StrikerStrikeProcessor implements CaromBoardState {
    @Override
    public void applyStrike(CaromBoard board, Player player) {
        player.getRuleManager().setFoulCount(player.getRuleManager().getFoulCount() + 1);
        player.setPoints(player.getPoints() - 1);
        if (player.getRuleManager().getFoulCount() == 3) {
            player.setPoints(player.getPoints() - 1);
            player.getRuleManager().setFoulCount(0);
        }
        player.setLastStrike("strikerstrike");

    }
}
