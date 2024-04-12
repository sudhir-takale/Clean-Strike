package com.amaap.cleanstrike.domain.model.valueobject;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;

public class RedStrike implements CaromBoardState {

    @Override
    public void applyStrike(Board board, int playerId) {
        Player player = board.getPlayers().get(playerId);
        player.setPoints(player.getPoints() + 3);
        board.setRedCoins(board.getRedCoins() - 1);
    }
}
