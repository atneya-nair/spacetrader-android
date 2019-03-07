package edu.gatech.cs2340.spacetraderredux.di

import dagger.BindsInstance
import dagger.Component
import edu.gatech.cs2340.spacetraderredux.domain.Player
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerConfiguration


@Component(modules = arrayOf(PlayerModule::class))
interface PlayerComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun playerConfig(config: PlayerConfiguration): Builder
        fun build(): PlayerComponent
    }
}