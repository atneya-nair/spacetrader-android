package edu.gatech.cs2340.spacetraderredux.ui.mappane

import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState

interface MapView {
    fun initialiseView()
    fun onInvalidTravel(message: String)
    fun onSuccessfulTravel()
    fun displaySolarSystems(solarSystems: List<SolarSystem>, playerState: PlayerState)
    fun showConfirmationDialogue(solarSystem: SolarSystem, dialogue: String)
}