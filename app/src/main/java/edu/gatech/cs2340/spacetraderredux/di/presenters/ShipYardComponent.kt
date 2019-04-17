package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.di.AppComponent
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.ui.shipyard.ShipYardActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ShipYardModule::class])
interface ShipYardComponent {
    fun inject(shipYardActivity: ShipYardActivity)
}