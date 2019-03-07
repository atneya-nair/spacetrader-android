package edu.gatech.cs2340.spacetraderredux.di

import dagger.Module
import javax.inject.Singleton

import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.domain.Player
import edu.gatech.cs2340.spacetraderredux.domain.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerConfiguration
import javax.inject.Inject
import javax.inject.Named


@Module
class PlayerModule {

    @Provides
    @Singleton
    fun provideNewPlayer(playerConfiguration: PlayerConfiguration): Player {
        return Player(playerConfiguration.getName()!!, playerConfiguration.getDifficulty()!!,
                playerConfiguration.getSkills()!!, Ship(), 1000)
    }

}
