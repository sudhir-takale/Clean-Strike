package com.amaap.cleanstrike.domain.service.outcomeprocesses;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;

public class NonStrikeProcessor implements CaromBoardState {
    @Override
    public void applyStrike(CaromBoard board, Player player) {
        if (player.getRuleManager().getNonStrikeCount() == 3) {
            player.setPoints(player.getPoints() - 1);
        }
        if (player.getLastStrike().equalsIgnoreCase("nonStrike")) {
            player.getRuleManager().setNonStrikeCount(player.getRuleManager().getNonStrikeCount() + 1);
        }
        player.getRuleManager().setNonStrikeCount(player.getRuleManager().getNonStrikeCount() + 1);
        player.setLastStrike("nonStrike");
    }
}
