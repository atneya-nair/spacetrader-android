package edu.gatech.cs2340.spacetraderredux.domain


import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SolarSystemName
import java.util.*
import javax.inject.Inject

class Universe @Inject constructor() {
    val solarSystems: List<SolarSystem>
    val totalSystems = 25

    init {
        //TODO Make first planet a good one near the center
        //TODO fuzzy spread
        //TODO dagger this
        val solarSystemList = ArrayList<SolarSystem>()
        val usedPoints = HashSet<Point>()
        val rand = Random()
        val solarSystemNamesLen = SolarSystemName.values().size
        val selectedNames = HashSet<String>()
        var counter = 0

        while(counter < totalSystems) {
            val randomIndex = rand.nextInt(solarSystemNamesLen)
            val currSolarSystem = SolarSystemName.values()[randomIndex]
            if (!selectedNames.contains(currSolarSystem.name)) {
                var newLocation: Point
                do {
                    newLocation = Point(rand.nextInt(150), rand.nextInt(100))
                } while (usedPoints.contains(newLocation))
                usedPoints.add(newLocation)
                solarSystemList.add(SolarSystem(currSolarSystem, newLocation, rand))
                counter++
            }
            selectedNames.add(currSolarSystem.name)
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

    /*fun dumpToLog() {
        var logLeft = toString()
        while (logLeft.length > 4000) {
            Log.d("INFO", logLeft.substring(0, 4000))
            logLeft = logLeft.substring(4000)
        }
        Log.d("INFO", logLeft)
    }*/
}
