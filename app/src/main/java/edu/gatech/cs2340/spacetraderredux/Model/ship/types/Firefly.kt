package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Firefly : Ship("Firefly",
        ShipStorageUnits(20, 1, 1, 17, 3),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 25000),
        20,
        0,
        ShipHull(100, 1, 1))