package edu.gatech.cs2340.spacetraderredux.ui.systempane

import edu.gatech.cs2340.spacetraderredux.domain.entities.Politics
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.PlanetName
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SolarSystemName
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SpecialEvent
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel

interface SystemInfoView {
    fun displayInfo(solarSystemName: SolarSystemName, planetName: PlanetName, techLevel: TechLevel, politics: Politics, specialEvent: SpecialEvent);
}