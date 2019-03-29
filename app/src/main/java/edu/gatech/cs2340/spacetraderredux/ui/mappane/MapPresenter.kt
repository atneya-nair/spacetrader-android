package edu.gatech.cs2340.spacetraderredux.ui.mappane

import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import javax.inject.Inject

class MapPresenter @Inject constructor(
        mapUseCase:GetMapUseCase, travelUseCase: TravelUseCase): BasePresenter<MapView>() {
    fun onInitialise() {

    }
}