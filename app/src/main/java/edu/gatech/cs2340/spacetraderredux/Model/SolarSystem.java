package edu.gatech.cs2340.spacetraderredux.Model;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Collections;

public class SolarSystem {
    private String name;
    private static Point location;
    private Planet[] planets;

    public SolarSystem(String name){
        this.name = name;
        this.planets = planets;
        Point location = new Point(0,0);
    }

    public static void createSolarSystems(ArrayList<SolarSystem> solarSystems){
        ArrayList<Integer> xcoordinatelist = new ArrayList<>(200);
        ArrayList<Integer> ycoordinatelist = new ArrayList<>(200);
        for(int i = 0; i < 200; i ++){
            xcoordinatelist.add(i);
            ycoordinatelist.add(i);
        }
        Collections.shuffle(xcoordinatelist);
        Collections.shuffle(ycoordinatelist);
        for(int i = 0; i < SolarSystemName.values().length; i++){
             solarSystems.get(i).setLocation(xcoordinatelist.get(i), ycoordinatelist.get(i));

        }


    }

    public void setLocation(int x, int y){
        this.location = new Point(x, y);
    }
}
