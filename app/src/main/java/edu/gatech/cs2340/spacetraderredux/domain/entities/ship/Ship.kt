package edu.gatech.cs2340.spacetraderredux.domain.entities.ship

import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits


//TODO re abstract this, made concrete for persistence reasons.
open class Ship internal constructor(private val shipName: String,
                                         val storageUnits: ShipStorageUnits,
                                         val purchaseInfo: ShipPurchaseInfo,
                                         val occurrenceRate: Int,
                                         val traders: Int,
                                         val hull: ShipHull) {

    override fun toString(): String {
        return shipName;
    }
}
