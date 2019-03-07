package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Mosquito : Ship("Mosquito",
        ShipStorageUnits(15, 2, 1, 13, 5),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 30000),
        20,
        0,
        ShipHull(100, 1, 1))