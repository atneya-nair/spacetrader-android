package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerConfiguration
import edu.gatech.cs2340.spacetraderredux.domain.usecases.SaveNewGame
import edu.gatech.cs2340.spacetraderredux.ui.configuration.ConfigurationPresenter

@Module
class ConfigurationModule {
    @PerActivity
    @Provides
    fun provideConfigurationPresenter(
            saveNewGame: SaveNewGame,
            playerConfiguration:PlayerConfiguration) = ConfigurationPresenter(saveNewGame, playerConfiguration)
}