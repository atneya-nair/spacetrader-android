package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Gnat : Ship("Gnat",
        ShipStorageUnits(15, 1, 0, 14, 2),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 10000),
        28,
        0,
        ShipHull(100, 1, 1))