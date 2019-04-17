package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Beetle : Ship("Beetle",
        ShipStorageUnits(50, 0, 1, 14, 10),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 80000),
        3,
        0,
        ShipHull(50, 1, 2, 50))