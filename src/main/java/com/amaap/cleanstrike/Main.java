package com.amaap.cleanstrike;

import com.amaap.cleanstrike.controller.BoardController;
import com.amaap.cleanstrike.controller.PlayerController;
import com.amaap.cleanstrike.controller.dto.Response;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {


        Injector injector = Guice.createInjector(new DemoModule());
        BoardController controller = injector.getInstance(BoardController.class);
        PlayerController playerController = injector.getInstance(PlayerController.class);

        Response player = playerController.createPlayer();
        Response player2 = playerController.createPlayer();
        Response board = controller.createBoard(9, 1);
        System.out.println("Player 1" + player);
        System.out.println("Player 2" + player2);
        System.out.println(board);
        System.out.println("Winner is " + controller.startGame());
    }
}
