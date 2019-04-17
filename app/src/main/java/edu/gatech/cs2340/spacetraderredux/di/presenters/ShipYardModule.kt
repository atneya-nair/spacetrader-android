package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.ui.shipyard.ShipYardPresenter


@Module
class ShipYardModule {
    @PerActivity
    @Provides
    fun provideShipYardPresenter(
            currentStateUseCase: GetCurrentStateUseCase) = ShipYardPresenter(currentStateUseCase)
}