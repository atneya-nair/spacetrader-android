package edu.gatech.cs2340.spacetraderredux

import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.CargoHold
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import java.lang.IllegalStateException

class SeungJeUnitTest {
    val HOLD_SIZE = 100
    val dummyTradeable = Tradeable.FIREARMS
    @Test
    fun testDecOneCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(dummyTradeable, 2)
        cargoHold.removeItems(dummyTradeable, 1)
        assertEquals(HOLD_SIZE - 1, cargoHold.capacityLeft)
        var expectedItems = HashMap<Tradeable, Int>()
        expectedItems.put(dummyTradeable, 1)
        assertEquals(expectedItems, cargoHold.getItems())
    }

    @Test
    fun testDecTwoCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(dummyTradeable, 3)
        cargoHold.removeItems(dummyTradeable, 2)
        assertEquals(HOLD_SIZE - 1, cargoHold.capacityLeft)
        var expectedItems = HashMap<Tradeable, Int>()
        expectedItems.put(dummyTradeable, 1)
        assertEquals(expectedItems, cargoHold.getItems())
    }

    @Test
    fun testDecToEmptyCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(dummyTradeable, 1)
        cargoHold.removeItems(dummyTradeable, 1)
        assertEquals(HOLD_SIZE, cargoHold.capacityLeft)
        assertEquals(0, cargoHold.getItems().size)
    }

    @Test(expected=IllegalStateException::class)
    fun testDecEmptyCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.removeItems(dummyTradeable, 1)
        fail()
    }

    @Test(expected=IllegalStateException::class)
    fun testDecMoreThanAvailableCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(dummyTradeable, 1)
        cargoHold.removeItems(dummyTradeable, 2)
        fail()
    }

    @Test
    fun testDecNoneCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.addItems(dummyTradeable, 1)
        cargoHold.removeItems(dummyTradeable, 0)
        assertEquals(HOLD_SIZE - 1, cargoHold.capacityLeft)
        var expectedItems = HashMap<Tradeable, Int>()
        expectedItems.put(dummyTradeable, 1)
        assertEquals(expectedItems, cargoHold.getItems())
    }

    @Test(expected=IllegalStateException::class)
    fun testDecNonExistentCargoHold() {
        var cargoHold = CargoHold(HOLD_SIZE)
        cargoHold.removeItems(dummyTradeable, 1)
        fail()
    }
}
