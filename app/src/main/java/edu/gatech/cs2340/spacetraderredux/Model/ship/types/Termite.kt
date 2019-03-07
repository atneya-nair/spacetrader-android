package edu.gatech.cs2340.spacetraderredux.Model.ship.types

import edu.gatech.cs2340.spacetraderredux.Model.TechLevel
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.Model.ship.ShipStorageUnits

class Termite : Ship("Termite",
        ShipStorageUnits(60, 1, 3, 13, 20),
        ShipPurchaseInfo(TechLevel.HI_TECH, 225000),
        2,
        3,
        ShipHull(200, 4, 4))