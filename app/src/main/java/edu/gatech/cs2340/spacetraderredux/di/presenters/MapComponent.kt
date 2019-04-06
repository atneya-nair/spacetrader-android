package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.di.AppComponent
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [MapModule::class])
interface MapComponent {
    fun inject(mapActivity: MapActivity)
}