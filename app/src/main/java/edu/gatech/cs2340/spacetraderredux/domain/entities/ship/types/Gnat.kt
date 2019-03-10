package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Gnat : Ship("Gnat",
        ShipStorageUnits(15, 1, 0, 14, 2),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 10000),
        28,
        0,
        ShipHull(100, 1, 1))