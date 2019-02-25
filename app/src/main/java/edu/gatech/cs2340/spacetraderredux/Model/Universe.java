package edu.gatech.cs2340.spacetraderredux.Model;

import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Universe {
    private final List<SolarSystem> solarSystemList;

    Universe(){
        ArrayList<SolarSystem> solarSystemList = new ArrayList<>();
        Set<Point> usedPoints = new HashSet<>();
        Random seed = new Random();
        for (SolarSystemName name : SolarSystemName.values()) {
            Point newLocation;
            do {
                newLocation = new Point(seed.nextInt(150), seed.nextInt(100));
            } while(usedPoints.contains(newLocation));
            usedPoints.add(newLocation);

            solarSystemList.add(new SolarSystem(name, newLocation, seed));
        }

        this.solarSystemList = Collections.unmodifiableList(solarSystemList);
    }

    public List<SolarSystem> getSolarSystems() {
        return solarSystemList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Universe containing solar systems: {");
        for (int i = 0; i < solarSystemList.size() - 1; i++) {
            sb.append(solarSystemList.get(i) + ", ");
        }
        sb.append(solarSystemList.get(solarSystemList.size() - 1) + "}");
        return sb.toString();
    }

    public void dumpToLog() {
        String logLeft = toString();
        while (logLeft.length() > 4000) {
            Log.d("INFO", logLeft.substring(0, 4000));
            logLeft = logLeft.substring(4000);
        }
        Log.d("INFO", logLeft);
    }
}
