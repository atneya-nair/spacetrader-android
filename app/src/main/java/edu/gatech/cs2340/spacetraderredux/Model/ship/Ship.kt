package edu.gatech.cs2340.spacetraderredux.Model.ship

abstract class Ship internal constructor(val shipName: String,
                                         val storageUnits: ShipStorageUnits,
                                         val purchaseInfo: ShipPurchaseInfo,
                                         val occurrenceRate: Int,
                                         val traders: Int,
                                         val hull: ShipHull) {

    override fun toString(): String {
        return shipName;
    }
}
