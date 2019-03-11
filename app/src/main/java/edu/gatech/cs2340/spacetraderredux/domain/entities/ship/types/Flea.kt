package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Flea : Ship("Flea",
        ShipStorageUnits(10, 0, 0, 20, 1),
        ShipPurchaseInfo(TechLevel.EARLY_INDUSTRIAL, 2000),
        2,
        0,
        ShipHull(25, 1, 0))