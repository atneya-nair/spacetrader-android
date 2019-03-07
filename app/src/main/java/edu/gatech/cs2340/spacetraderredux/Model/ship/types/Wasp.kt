package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Wasp : Ship("Wasp",
        ShipStorageUnits(35, 3, 2, 14, 20),
        ShipPurchaseInfo(TechLevel.HI_TECH, 300000),
        2,
        4,
        ShipHull(200, 5, 4))