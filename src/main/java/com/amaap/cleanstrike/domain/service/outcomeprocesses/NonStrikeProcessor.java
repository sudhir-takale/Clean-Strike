package com.amaap.cleanstrike.domain.service.outcomeprocesses;

import com.amaap.cleanstrike.domain.model.entity.Board;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;

public class NonStrikeProcessor implements CaromBoardState {
    @Override
    public void applyStrike(Board board, int playerId) {
        Player player = board.getPlayers().get(playerId);
        player.getRuleManager().setFailCount(player.getRuleManager().getFailCount() + 1);
    }
}
