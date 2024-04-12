package com.amaap.cleanstrike.domain.model.valueobject;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;

public class Strike  implements CaromBoardState {
    @Override
    public void applyStrike(Board board, int playerId) {
        Player player = board.getPlayers().get(playerId);
        player.setPoints(player.getPoints() + 1);
        board.setBlackCoins(board.getBlackCoins() - 1);
    }
}
