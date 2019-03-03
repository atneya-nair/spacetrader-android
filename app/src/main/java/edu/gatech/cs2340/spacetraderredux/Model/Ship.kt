package edu.gatech.cs2340.spacetraderredux.Model

class Ship {
    internal var shipType: ShipType

    init {
        shipType = ShipType.GNAT
    }

    override fun toString(): String {
        return shipType.toString()
    }
}
