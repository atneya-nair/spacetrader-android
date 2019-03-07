package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Beetle : Ship("Beetle",
        ShipStorageUnits(50, 0, 1, 14, 10),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 80000),
        3,
        0,
        ShipHull(50, 1, 2))