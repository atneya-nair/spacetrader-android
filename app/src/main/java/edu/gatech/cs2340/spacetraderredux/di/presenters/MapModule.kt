package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetMapUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TravelUseCase
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapPresenter


@Module
class MapModule {
     @PerActivity
     @Provides
     fun provideMapPresenter(
             mapUseCase: GetMapUseCase,
             travelUseCase: TravelUseCase,
             currentStateUseCase: GetCurrentStateUseCase) = MapPresenter(
             mapUseCase, travelUseCase, currentStateUseCase)
}