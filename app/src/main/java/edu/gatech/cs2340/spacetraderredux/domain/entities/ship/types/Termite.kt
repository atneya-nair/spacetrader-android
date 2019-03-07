package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Termite : Ship("Termite",
        ShipStorageUnits(60, 1, 3, 13, 20),
        ShipPurchaseInfo(TechLevel.HI_TECH, 225000),
        2,
        3,
        ShipHull(200, 4, 4))