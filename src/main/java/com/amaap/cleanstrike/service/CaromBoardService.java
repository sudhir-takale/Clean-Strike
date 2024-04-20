package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.WinnerEvaluator;
import com.amaap.cleanstrike.repository.CaromBoardRepository;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import com.amaap.cleanstrike.service.validator.BoardValidator;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class CaromBoardService {
    private final PlayerService playerService;
    private final CaromBoardRepository caromBoardRepository;

    @Inject
    public CaromBoardService(CaromBoardRepository caromBoardRepository, PlayerService playerService) {
        this.caromBoardRepository = caromBoardRepository;
        this.playerService = playerService;
    }

    public boolean create(int blackCoins, int redCoin) throws InvalidArgumentException {
        if (!BoardValidator.validate(blackCoins, redCoin)) {
            throw new InvalidArgumentException("Check your arguments");
        }
        CaromBoard board = new CaromBoard(blackCoins, redCoin);
        caromBoardRepository.save(board);
        return true;
    }

    public CaromBoard getBoard(int i) {
        return caromBoardRepository.getBoard(i);
    }

    public String getWinner() {
        CaromBoard board = getBoard(1);
        List<Player> players = getPlayersToAssign();
        board.setPlayers(players);
        WinnerEvaluator winnerEvaluator = new WinnerEvaluator(playerService);
        return winnerEvaluator.getWinner(board);
    }

    private List<Player> getPlayersToAssign() {
        List<Player> playersToAssign = new ArrayList<Player>();
        List<Player> players = playerService.getPlayer();
        for (Player player : players) {
            if (playersToAssign.size() == 2) {
                break;
            }
            playersToAssign.add(player);
        }
        return playersToAssign;
    }


}
