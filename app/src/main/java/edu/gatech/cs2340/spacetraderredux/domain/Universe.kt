package edu.gatech.cs2340.spacetraderredux.domain

import android.graphics.Point
import android.util.Log
import edu.gatech.cs2340.spacetraderredux.domain.entities.SolarSystemName

import java.util.ArrayList
import java.util.Collections
import java.util.HashSet
import java.util.Random

class Universe internal constructor() {
    val solarSystems: List<SolarSystem>

    init {
        val solarSystemList = ArrayList<SolarSystem>()
        val usedPoints = HashSet<Point>()
        val rand = Random()
        for (name in SolarSystemName.values()) {
            var newLocation: Point
            do {
                newLocation = Point(rand.nextInt(150), rand.nextInt(100))
            } while (usedPoints.contains(newLocation))
            usedPoints.add(newLocation)

            solarSystemList.add(SolarSystem(name, newLocation, rand))
        }

        this.solarSystems = Collections.unmodifiableList(solarSystemList)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("Universe containing solar systems: {")
        for (i in 0 until solarSystems.size - 1) {
            sb.append(solarSystems[i].toString() + ", ")
        }
        sb.append(solarSystems[solarSystems.size - 1].toString() + "}")
        return sb.toString()
    }

    fun dumpToLog() {
        var logLeft = toString()
        while (logLeft.length > 4000) {
            Log.d("INFO", logLeft.substring(0, 4000))
            logLeft = logLeft.substring(4000)
        }
        Log.d("INFO", logLeft)
    }
}
