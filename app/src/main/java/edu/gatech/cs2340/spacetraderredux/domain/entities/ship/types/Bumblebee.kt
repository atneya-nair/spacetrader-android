package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipHull
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipPurchaseInfo
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.ShipStorageUnits

class Bumblebee : Ship("Bumblebee",
        ShipStorageUnits(25, 1, 2, 15, 7),
        ShipPurchaseInfo(TechLevel.INDUSTRIAL, 60000),
        15,
        0,
        ShipHull(100, 1, 2, 100))