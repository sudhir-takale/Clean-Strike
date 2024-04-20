package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.CaromBoard;


public interface CaromBoardRepository {


    int save(CaromBoard board);

    CaromBoard getBoard(int id);
}
