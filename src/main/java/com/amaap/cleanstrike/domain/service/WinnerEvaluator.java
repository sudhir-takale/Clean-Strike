package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.outcomeprocesses.*;
import com.amaap.cleanstrike.service.PlayerService;

import java.util.ArrayList;
import java.util.List;

public class WinnerEvaluator {
    private final PlayerService playerService;

    public WinnerEvaluator(PlayerService playerService) {
        this.playerService = playerService;
    }


    public String getWinner(CaromBoard caromBoard) {
        int MAX_SCORE_TO_WIN = 5;
        int MIN_SCORE_TO_WIN = 3;

        List<CaromBoardState> boardStates = new ArrayList<>();
        boardStates.add(new RedStrikeProcessor());
        boardStates.add(new MultiStrikeProcessor());
        boardStates.add(new StrikeProcessor());
        boardStates.add(new DefunctCoinProcessor());
        boardStates.add(new StrikerStrikeProcessor());

        Player firstPlayer = caromBoard.getPlayers().get(0);
        Player secondPlayer = caromBoard.getPlayers().get(1);

        while (true) {

            int randomIndex = playerService.getRandomIndex(boardStates.size());
            CaromBoardState selectedState = boardStates.get(randomIndex);

            selectedState.applyStrike(caromBoard, firstPlayer);
            System.out.println("Player one points :" + firstPlayer.getPoints());

            int newRandomIndex = playerService.getRandomIndex(boardStates.size());
            CaromBoardState newSelectedState = boardStates.get(newRandomIndex);

            newSelectedState.applyStrike(caromBoard, secondPlayer);
            System.out.println("Player two points :" + secondPlayer.getPoints());


            if (caromBoard.getBlackCoins() == 0 && caromBoard.getRedCoins() == 0) {
                System.out.println("Draw");
                return "Draw";
            } else if (firstPlayer.getPoints() >= MAX_SCORE_TO_WIN && firstPlayer.getPoints() - secondPlayer.getPoints() >= MIN_SCORE_TO_WIN) {
                System.out.println(caromBoard.getBlackCoins() + " " + caromBoard.getRedCoins());
                System.out.println("firstPlayer");
                return "Player 1";

            } else if (secondPlayer.getPoints() >= MAX_SCORE_TO_WIN && secondPlayer.getPoints() - firstPlayer.getPoints() >= MIN_SCORE_TO_WIN) {
                System.out.println(caromBoard.getBlackCoins() + " " + caromBoard.getRedCoins());
                System.out.println("secondPlayer");
                return "Player 2";


            }
        }

    }
}