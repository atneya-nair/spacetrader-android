package edu.gatech.cs2340.spacetraderredux.domain

import edu.gatech.cs2340.spacetraderredux.domain.entities.ShipType

class Ship {
    internal var shipType: ShipType

    init {
        shipType = ShipType.GNAT
    }

    override fun toString(): String {
        return shipType.toString()
    }
}
