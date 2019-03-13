package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.di.AppComponent
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.di.UseCaseModule
import edu.gatech.cs2340.spacetraderredux.ui.configuration.ConfigurationActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ConfigurationModule::class])
interface ConfigurationComponent {
    fun inject(configurationActivity: ConfigurationActivity)
}