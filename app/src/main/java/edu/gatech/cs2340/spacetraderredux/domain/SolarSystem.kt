package edu.gatech.cs2340.spacetraderredux.domain

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SolarSystemName

import java.util.Random

class SolarSystem(val name: SolarSystemName, val location: Point, rand: Random) {
    val planets: Array<Planet>

    init {
        var set = HashSet<String>()
        this.planets = Array(rand.nextInt(10) + 1){generateRandomPlanet(rand)}
        for (i in 0..planets.size-1) {
            var currPlanet = generateRandomPlanet(rand)
            while (set.contains(currPlanet.name.name)) {
                currPlanet = generateRandomPlanet(rand)
            }
            set.add(currPlanet.name.name)
        }
    }

    private fun generateRandomPlanet(rand: Random): Planet {
        return Planet(rand);
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Solar System " + name.displayName + " at (" + location.x + ", " + location.y + ") containing planets: {")
        for (i in 0 until planets.size - 1) {
            sb.append(planets[i].toString() + ", ")
        }
        sb.append(planets[planets.size - 1].toString() + "}")
        return sb.toString()
    }
}
