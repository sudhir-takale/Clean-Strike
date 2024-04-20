package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.Player;

import java.util.List;

public interface PlayerRepository {


    List<Player> getPlayers();

    void save(Player player);
}
