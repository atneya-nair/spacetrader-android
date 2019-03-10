package edu.gatech.cs2340.spacetraderredux.di

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.ui.configuration.ConfigurationPresenter
import javax.inject.Singleton

@Singleton
@Component
interface PlayerConfigurationComponent {
    fun inject(presenter: ConfigurationPresenter)
}