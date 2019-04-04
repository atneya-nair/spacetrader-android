package edu.gatech.cs2340.spacetraderredux

import edu.gatech.cs2340.spacetraderredux.domain.Point
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.Universe
import org.junit.Assert.*
import org.junit.Test

class KrisUnitTest {
    var universe : Universe
    val expectedTotalSystems = 25
    val numberIterations = 10000
    var curr = 0

    init {
        universe = Universe()
        System.out.println(universe.solarSystems)
    }

    @Test
    fun testExpectedSolarSystemSize() {
        assertEquals(expectedTotalSystems, universe.totalSystems)
    }

    @Test
    fun testMultipleExpectedSolarSystemNames() {
        for (i in 1..numberIterations) {
            universe = Universe()
            testExpectedSolarSystemNames()
        }
    }

    @Test
    fun testMultipleSolarSystemCoordinates() {
        for (i in 1..numberIterations) {
            universe = Universe()
            testExpectedSolarSystemCoordinates()
        }
    }

    @Test
    fun testExpectedSolarSystemCoordinates() {
        val pointSet = HashSet<Point>()
        for (index in 0..expectedTotalSystems - 1) {
            if (pointSet.contains(universe.solarSystems[index].location)) {
                fail()
            }
            if (universe.solarSystems[index].location.x < 0 || universe.solarSystems[index].location.x >= 150) {
                fail()
            }
            if (universe.solarSystems[index].location.y < 0 || universe.solarSystems[index].location.y >= 150) {
                fail()
            }
        }
    }

    @Test
    fun testExpectedSolarSystemNames() {
        val solarSystemName = HashSet<String>();
        for (solarSystem : SolarSystem in universe.solarSystems) {
            if (solarSystemName.contains(solarSystem.name.displayName)) {
                fail()
            }
            solarSystemName.add(solarSystem.name.displayName)
        }
    }

    @Test
    fun testToString() {
        assertNotNull(universe.toString())
    }
}