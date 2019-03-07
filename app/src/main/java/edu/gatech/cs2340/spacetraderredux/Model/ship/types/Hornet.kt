package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Hornet : Ship("Hornet",
        ShipStorageUnits(20, 3, 2, 16, 15),
        ShipPurchaseInfo(TechLevel.POST_INDUSTRIAL, 100000),
        6,
        1,
        ShipHull(150, 2, 3))
