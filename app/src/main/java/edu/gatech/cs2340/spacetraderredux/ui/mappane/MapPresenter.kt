package edu.gatech.cs2340.spacetraderredux.ui.mappane

import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import javax.inject.Inject

class MapPresenter @Inject constructor(
        mapUseCase: GetMapUseCase, travelUseCase: TravelUseCase, currentStateUseCase: GetCurrentStateUseCase): BasePresenter<MapView>() {
    fun onInitialise() {

    }
}