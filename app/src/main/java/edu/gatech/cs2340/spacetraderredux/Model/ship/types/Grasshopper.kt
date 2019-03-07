package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Grasshopper : Ship("Grasshopper",
        ShipStorageUnits(30, 2, 2, 15, 15),
        ShipPurchaseInfo(TechLevel.POST_INDUSTRIAL, 150000),
        2,
        2,
        ShipHull(150, 3, 3))