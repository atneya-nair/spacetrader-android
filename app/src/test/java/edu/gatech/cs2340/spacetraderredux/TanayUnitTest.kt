package edu.gatech.cs2340.spacetraderredux

import edu.gatech.cs2340.spacetraderredux.domain.Point
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.Universe
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.CargoHold
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import kotlin.IllegalStateException
import kotlin.random.Random

class TanayUnitTest {
    private var cargoHold : CargoHold
    private val hiCapacity = 1000
    private val loCapacity = 0
    private var tradeable : Tradeable
    private var hiCapacityLeft = hiCapacity
    private var loCapacityLeft = loCapacity

    init {
        cargoHold = CargoHold(hiCapacity)
        tradeable = Tradeable.values()[Random.nextInt(Tradeable.values().size)]
    }

    @Test
    fun testHiAddFullCargoHold() {
        cargoHold.addItems(tradeable, hiCapacity)
        hiCapacityLeft -= hiCapacity
        assertEquals(hiCapacityLeft, cargoHold.capacityLeft)
    }

    @Test
    fun testLoAddFullCargoHold() {
        cargoHold = CargoHold(loCapacity)
        cargoHold.addItems(tradeable, loCapacity)
        assertEquals(loCapacityLeft, cargoHold.capacityLeft)
    }

    @Test(expected=IllegalStateException::class)
    fun testLoAddOverflowCargoHold() {
        cargoHold = CargoHold(loCapacity)
        cargoHold.addItems(tradeable, loCapacity + 1)
        fail()
    }

    @Test
    fun testHiAddNoItemsCargoHold() {
        cargoHold.addItems(tradeable, 0)
        assertEquals(hiCapacity, cargoHold.capacityLeft)
    }

    @Test(expected=IllegalStateException::class)
    fun testHiAddOverflowCargoHold() {
        cargoHold.addItems(tradeable, hiCapacity + 1)
        fail()
    }

    @Test(expected=IllegalStateException::class)
    fun testHiAddRandomCargoHold() {
        val random = Random
        while (hiCapacityLeft >= 0) {
            val currAddition = random.nextInt(1, hiCapacity/10)
            hiCapacityLeft -= currAddition
            cargoHold.addItems(tradeable, currAddition)
            assertEquals(hiCapacityLeft, cargoHold.capacityLeft)
        }
        fail()
    }
}