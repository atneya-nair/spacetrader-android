package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Grasshopper : Ship("Grasshopper",
        ShipStorageUnits(30, 2, 2, 15, 15),
        ShipPurchaseInfo(TechLevel.POST_INDUSTRIAL, 150000),
        2,
        2,
        ShipHull(150, 3, 3))