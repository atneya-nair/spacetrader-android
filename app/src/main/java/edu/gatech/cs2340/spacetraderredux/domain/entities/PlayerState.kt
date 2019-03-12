package edu.gatech.cs2340.spacetraderredux.domain.entities

import edu.gatech.cs2340.spacetraderredux.domain.Planet
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship


data class PlayerState(val charName: String, val difficulty: Difficulty,
                       val skills: Skills, val currPlanet: Planet,
                       var ship: Ship, var credits: Int) {
}
