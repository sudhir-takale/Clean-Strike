package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.outcomeprocesses.*;
import com.amaap.cleanstrike.service.PlayerService;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class WinnerEvaluator {
    private final PlayerService playerService;
    private boolean isGameOver = false;

    @Inject
    public WinnerEvaluator(PlayerService playerService) {
        this.playerService = playerService;
    }

    private List<CaromBoardState> boardStates() {
        List<CaromBoardState> boardStates = new ArrayList<>();
        boardStates.add(new RedStrikeProcessor());
        boardStates.add(new MultiStrikeProcessor());
        boardStates.add(new StrikeProcessor());
        boardStates.add(new DefunctCoinProcessor());
        boardStates.add(new StrikerStrikeProcessor());
        boardStates.add(new NonStrikeProcessor());
        return boardStates;
    }

    public String getWinner(CaromBoard caromBoard) {
        List<CaromBoardState> boardStates = boardStates();
        Player firstPlayer = caromBoard.getPlayers().get(0);
        Player secondPlayer = caromBoard.getPlayers().get(1);

        while (!isGameOver) {
            playerService.applyRandomStrike(boardStates, caromBoard, firstPlayer);

            String result = checkScore(firstPlayer, secondPlayer);
            if (result.equals("Player 1")) return result;

            playerService.applyRandomStrike(boardStates, caromBoard, secondPlayer);

            result = checkScore(firstPlayer, secondPlayer);
            if (result.equals("Player 2")) return result;
        }
        return "Draw";
    }


    private String checkScore(Player firstPlayer, Player secondPlayer) {
        int MAX_SCORE_TO_WIN = 5;
        int MIN_SCORE_TO_WIN = 3;

        if (firstPlayer.getPoints() >= MAX_SCORE_TO_WIN && firstPlayer.getPoints() - secondPlayer.getPoints() >= MIN_SCORE_TO_WIN) {
            System.out.println("Player 1 wins by " + firstPlayer.getPoints() + " to " + secondPlayer.getPoints());
            isGameOver = true;
            return "Player 1";
        } else if (secondPlayer.getPoints() >= MAX_SCORE_TO_WIN && secondPlayer.getPoints() - firstPlayer.getPoints() >= MIN_SCORE_TO_WIN) {
            System.out.println("Player 2 wins by " + secondPlayer.getPoints() + " to " + firstPlayer.getPoints());
            isGameOver = true;
            return "Player 2";
        } else return "Draw";
    }
}
