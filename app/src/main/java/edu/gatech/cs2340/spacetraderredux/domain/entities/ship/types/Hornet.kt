package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Hornet : Ship("Hornet",
        ShipStorageUnits(20, 3, 2, 16, 15),
        ShipPurchaseInfo(TechLevel.POST_INDUSTRIAL, 100000),
        6,
        1,
        ShipHull(150, 2, 3))
