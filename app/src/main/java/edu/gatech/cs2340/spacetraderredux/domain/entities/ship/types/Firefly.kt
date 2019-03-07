package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Firefly : Ship("Firefly",
        ShipStorageUnits(20, 1, 1, 17, 3),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 25000),
        20,
        0,
        ShipHull(100, 1, 1))