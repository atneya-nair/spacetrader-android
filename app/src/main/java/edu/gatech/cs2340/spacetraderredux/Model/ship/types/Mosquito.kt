package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Mosquito : Ship("Mosquito",
        ShipStorageUnits(15, 2, 1, 13, 5),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 30000),
        20,
        0,
        ShipHull(100, 1, 1))