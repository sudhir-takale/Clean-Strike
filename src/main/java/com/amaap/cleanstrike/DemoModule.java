package com.amaap.cleanstrike;

import com.amaap.cleanstrike.repository.CaromBoardRepository;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.db.FakeInMemoryDatabaseImpl;
import com.amaap.cleanstrike.repository.impl.CaromBoardRepositoryImpl;
import com.amaap.cleanstrike.repository.impl.PlayerRepositoryImpl;
import com.google.inject.AbstractModule;

public class DemoModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(PlayerRepository.class).to(PlayerRepositoryImpl.class);
        bind(CaromBoardRepository.class).to(CaromBoardRepositoryImpl.class);
        bind(FakeInMemoryDatabase.class).to(FakeInMemoryDatabaseImpl.class).asEagerSingleton();
    }
}
