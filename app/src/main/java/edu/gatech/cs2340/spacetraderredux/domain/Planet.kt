package edu.gatech.cs2340.spacetraderredux.domain

import edu.gatech.cs2340.spacetraderredux.domain.entities.Politics
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.PlanetName
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.Resource
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SpecialEvent
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import java.util.*

class Planet(rand: Random) {

    val name: PlanetName = PlanetName.values()[rand.nextInt(PlanetName.values().size)]
    val resource: Resource = Resource.values()[rand.nextInt(Resource.values().size - 1)]
    val techLevel: TechLevel = TechLevel.values()[rand.nextInt(TechLevel.values().size)]
    var specialEvent: SpecialEvent = SpecialEvent.UNEVENTFUL
    val politics: Politics = Politics.DEMOCRACY// TODO Initialize this

    override fun toString(): String {
        return "Planet " + name.name + " with resource: " + resource.name + " and tech level: " +
                techLevel.name
    }
}
