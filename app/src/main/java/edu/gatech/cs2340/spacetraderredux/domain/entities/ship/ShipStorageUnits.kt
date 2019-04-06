package edu.gatech.cs2340.spacetraderredux.domain.entities.ship

class ShipStorageUnits constructor(cargoHoldSize: Int, weaponStorageSize: Int,
                                   shieldStorageSize: Int, fuelTankSize: Int, fuelCost: Int) {
    val cargoHold: CargoHold = CargoHold(cargoHoldSize)
    val weaponStorage: WeaponStorage = WeaponStorage(weaponStorageSize)
    val shieldStorage: ShieldStorage = ShieldStorage(shieldStorageSize)
    val fuelTank: FuelTank = FuelTank(fuelTankSize, fuelCost, fuelTankSize)
}
