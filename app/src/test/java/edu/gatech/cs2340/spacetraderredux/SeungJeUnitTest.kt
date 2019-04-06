package edu.gatech.cs2340.spacetraderredux

import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.CargoHold
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class SeungJeUnitTest {
    companion object {
        private const val HOLD_SIZE = 100
        private val DUMMY_TRADEABLE = Tradeable.FIREARMS
    }

    @Test
    fun testDecOneCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(DUMMY_TRADEABLE, 2)
        cargoHold.removeItems(DUMMY_TRADEABLE, 1)
        assertEquals(HOLD_SIZE - 1, cargoHold.capacityLeft)
        val expectedItems = HashMap<Tradeable, Int>()
        expectedItems[DUMMY_TRADEABLE] = 1
        assertEquals(expectedItems, cargoHold.getItems())
    }

    @Test
    fun testDecTwoCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(DUMMY_TRADEABLE, 3)
        cargoHold.removeItems(DUMMY_TRADEABLE, 2)
        assertEquals(HOLD_SIZE - 1, cargoHold.capacityLeft)
        val expectedItems = HashMap<Tradeable, Int>()
        expectedItems[DUMMY_TRADEABLE] = 1
        assertEquals(expectedItems, cargoHold.getItems())
    }

    @Test
    fun testDecToEmptyCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(DUMMY_TRADEABLE, 1)
        cargoHold.removeItems(DUMMY_TRADEABLE, 1)
        assertEquals(HOLD_SIZE, cargoHold.capacityLeft)
        assertEquals(0, cargoHold.getItems().size)
    }

    @Test(expected=IllegalStateException::class)
    fun testDecEmptyCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.removeItems(DUMMY_TRADEABLE, 1)
        fail()
    }

    @Test(expected=IllegalStateException::class)
    fun testDecMoreThanAvailableCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(DUMMY_TRADEABLE, 1)
        cargoHold.removeItems(DUMMY_TRADEABLE, 2)
        fail()
    }

    @Test
    fun testDecNoneCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(DUMMY_TRADEABLE, 1)
        cargoHold.removeItems(DUMMY_TRADEABLE, 0)
        assertEquals(HOLD_SIZE - 1, cargoHold.capacityLeft)
        val expectedItems = HashMap<Tradeable, Int>()
        expectedItems[DUMMY_TRADEABLE] = 1
        assertEquals(expectedItems, cargoHold.getItems())
    }

    @Test(expected=IllegalStateException::class)
    fun testDecNonExistentCargoHold() {
        val cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.removeItems(DUMMY_TRADEABLE, 1)
        fail()
    }
}
