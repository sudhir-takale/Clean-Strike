package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Board;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.WinnerEvaluator;
import com.amaap.cleanstrike.repository.BoardRepository;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import com.amaap.cleanstrike.service.validator.BoardValidator;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private final PlayerService playerService;
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository, PlayerService playerService) {
        this.boardRepository = boardRepository;
        this.playerService = playerService;
    }

    public boolean create(int blackCoins, int redCoin) throws InvalidArgumentException {
        if (BoardValidator.validate(blackCoins, redCoin)) {
            throw new InvalidArgumentException("Check your arguments");
        }
        Board board = new Board(blackCoins, redCoin);
        boardRepository.save(board);
        return true;
    }

    public Board getBoard(int i) {
        return boardRepository.getBoard(i);
    }

    public void getWinner(Board board) {

        List<Player> players = getPlayersToAssign();
        board.assignPlayers(players);
        WinnerEvaluator winnerEvaluator = new WinnerEvaluator();
        winnerEvaluator.getWinner(board);

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
