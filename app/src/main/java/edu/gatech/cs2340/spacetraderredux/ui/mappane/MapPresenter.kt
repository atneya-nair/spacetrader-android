package edu.gatech.cs2340.spacetraderredux.ui.mappane

import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetMapUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TravelUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import javax.inject.Inject

class MapPresenter @Inject constructor(
        mapUseCase: GetMapUseCase, travelUseCase: TravelUseCase, currentStateUseCase: GetCurrentStateUseCase): BasePresenter<MapView>() {

}