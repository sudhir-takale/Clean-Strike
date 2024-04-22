package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.CaromBoardState;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.google.inject.Inject;

import java.util.List;
import java.util.Random;

public class PlayerService {

    private final PlayerRepository playerRepository;

    @Inject
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean createPlayer() {

        Player player = new Player();
        playerRepository.save(player);
        return true;
    }

    public List<Player> getPlayer() {
        return playerRepository.getPlayers();
    }

    public int getRandomIndex(int maxLimit) {
        Random random = new Random();
        return Math.abs(random.nextInt(maxLimit));
    }


    public void applyRandomStrike(List<CaromBoardState> boardStates, CaromBoard caromBoard, Player player) {
        int randomIndex = getRandomIndex(boardStates.size());
        CaromBoardState selectedState = boardStates.get(randomIndex);
        selectedState.applyStrike(caromBoard, player);
    }

}
