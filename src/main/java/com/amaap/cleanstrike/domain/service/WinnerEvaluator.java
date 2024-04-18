package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.outcomeprocesses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WinnerEvaluator {

    private void attemptStrike(Player player, CaromBoard caromBoard, CaromBoardState selectedState) {
        System.out.println("Current player: " + player.getId());
        System.out.println("Playing strike: " + selectedState.getClass().getSimpleName());
        selectedState.applyStrike(caromBoard, player);
    }

    public void getWinner(CaromBoard carromBoard) {

        List<CaromBoardState> boardStates = new ArrayList<>();
        boardStates.add(new RedStrikeProcessor());
        boardStates.add(new MultiStrikeProcessor());
        boardStates.add(new StrikeProcessor());
        boardStates.add(new DefunctCoinProcessor());
        boardStates.add(new StrikerStrikeProcessor());

        Player player1 = carromBoard.getPlayers().get(0);
        Player player2 = carromBoard.getPlayers().get(1);

        while (true) {

            Random random = new Random();
            int randomIndex = random.nextInt(boardStates.size());
            CaromBoardState selectedState = boardStates.get(randomIndex);

            attemptStrike(player1, carromBoard, selectedState);
            System.out.println("Player one points :" + player1.getPoints());
            int newRandomIndex = random.nextInt(boardStates.size());
            CaromBoardState newSelectedState = boardStates.get(newRandomIndex);
            attemptStrike(player2, carromBoard, newSelectedState);
            System.out.println("Player two points :" + player2.getPoints());
            if (carromBoard.getBlackCoins() == 0 && carromBoard.getRedCoins() == 0) {
                System.out.println("Draw");
                break;
            }
            if (player1.getPoints() >= 5 && player1.getPoints() - player2.getPoints() >= 3) {
                System.out.println("player1");
                break;

            }
            if (player2.getPoints() >= 5 && player2.getPoints() - player1.getPoints() >= 3) {
                System.out.println("player1");
                break;

            }
        }

    }
}