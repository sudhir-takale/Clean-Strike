package com.amaap.cleanstrike.domain.model.valueobject;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;

public class NonStrike  implements CaromBoardState {
    @Override
    public void applyStrike(Board board, int playerId) {
        Player player = board.getPlayers().get(playerId);
        player.getRuleManager().setFailCount(player.getRuleManager().getFailCount() + 1);
    }
}
