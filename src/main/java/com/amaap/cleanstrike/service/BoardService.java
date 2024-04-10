package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.Board;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.service.WinnerEvaluator;
import com.amaap.cleanstrike.repository.BoardRepository;
import com.amaap.cleanstrike.service.exception.InvalidArgumentException;
import com.amaap.cleanstrike.service.validator.BoardValidator;

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
            throw new InvalidArgumentException("Check your coins");
        }
        List<Player> playerList = playerService.getPlayers();
        Board board = new Board(blackCoins, redCoin);
        board.assignPlayers(playerList);
        boardRepository.save(board);
        return true;
    }

    public Board getBoard(int i) {
        return boardRepository.getBoard(i);
    }

    public String getWinner(Board board) {

        return WinnerEvaluator.getWinner(board);
    }


}
