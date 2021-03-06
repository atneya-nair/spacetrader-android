package edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types

import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship
import kotlin.reflect.KClass

class ShipFactory {
    companion object {
        private val shipConstructors: MutableMap<KClass<out Ship>, () -> Ship> = HashMap()

        init {
            registerShip(Flea::class) {Flea()}
            registerShip(Gnat::class) {Gnat()}
            registerShip(Firefly::class) {Firefly()}
            registerShip(Mosquito::class) {Mosquito()}
            registerShip(Bumblebee::class) {Bumblebee()}
            registerShip(Beetle::class) {Beetle()}
            registerShip(Hornet::class) {Hornet()}
            registerShip(Grasshopper::class) {Grasshopper()}
            registerShip(Termite::class) {Termite()}
            registerShip(Wasp::class) {Wasp()}
        }

        fun createShip(shipClass: KClass<out Ship>): Ship {
            return shipConstructors[shipClass]!!()
        }

        private fun registerShip(shipType: KClass<out Ship>, shipConstructor: () -> Ship) {
            shipConstructors[shipType] = shipConstructor
        }
    }
}