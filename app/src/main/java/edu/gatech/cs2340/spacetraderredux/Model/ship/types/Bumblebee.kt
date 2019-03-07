package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Bumblebee : Ship("Bumblebee",
        ShipStorageUnits(25, 1, 2, 15, 7),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 60000),
        15,
        0,
        ShipHull(100, 1, 2))