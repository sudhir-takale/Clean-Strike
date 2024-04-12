package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.valueobject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WinnerEvaluator {
    private int currentPlayerIndex;

    public WinnerEvaluator() {
        this.currentPlayerIndex = 0;
    }

    public void getWinner(Board board) {

        List<CaromBoardState> boardStates = new ArrayList<>();
        boardStates.add(new RedStrike());
        boardStates.add(new MultiStrike());
        boardStates.add(new Strike());
        boardStates.add(new DefunctCoin());
        boardStates.add(new StrikerStrike());
//        boardStates.add(new NonStrike());


        List<Player> players = board.getPlayers();

        Player player1 = players.get(0);
        System.out.println("player 1" + player1.getId());
        Player player2 = players.get(1);
        System.out.println("player2 " + player2.getId());

        boolean isGameOver = false;
        while (!isGameOver) {
            if (board.getBlackCoins() + board.getRedCoins() == 0) {
                System.out.println("draw");
                isGameOver = true;
            } else if ((player1.getPoints() >= 5 && player1.getPoints() >= player2.getPoints() + 3)) {
                System.out.println("player 1");
                isGameOver = true;
            } else if ((player2.getPoints() >= 5 && player2.getPoints() >= player1.getPoints() + 3)) {
                System.out.println("player 2");
                isGameOver = true;
            } else {
                Player currentPlayer = players.get(currentPlayerIndex);
                System.out.println(currentPlayerIndex);
                System.out.println("Current player: " + currentPlayer.getId());

                Random random = new Random();
                int randomIndex = random.nextInt(boardStates.size());
                CaromBoardState selectedState = boardStates.get(randomIndex);
                System.out.println("Playing strike: " + selectedState.getClass().getSimpleName());
                selectedState.applyStrike(board, currentPlayer.getId());
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }

    }
}
