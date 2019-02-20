package edu.gatech.cs2340.spacetraderredux.Model;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Collections;

public class Universe {
    private ArrayList<SolarSystem> solarSystemList;

    public Universe(){
        solarSystemList = new ArrayList<>(SolarSystemName.values().length);
        for(int i = 0; i < SolarSystemName.values().length; i++){
            SolarSystem solToAdd = new SolarSystem(SolarSystemName.values()[i].toString());
            solarSystemList.add(solToAdd);
        }
        SolarSystem.createSolarSystems(solarSystemList);

    }

}
