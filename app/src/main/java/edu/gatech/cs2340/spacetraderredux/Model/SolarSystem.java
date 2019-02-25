package edu.gatech.cs2340.spacetraderredux.Model;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SolarSystem {
    private final SolarSystemName name;
    private final Point location;
    private final Planet[] planets;

    public SolarSystem(SolarSystemName name, Point location, Random seed){
        this.name = name;
        this.location = location;
        this.planets = new Planet[seed.nextInt(10) + 1];
        for (int i = 0; i < this.planets.length; i++) {
            this.planets[i] = new Planet(seed);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solar System " + name.name() + " at (" + location.x + ", " + location.y + ") containing planets: {");
        for (int i = 0; i < planets.length - 1; i++) {
            sb.append(planets[i] + ", ");
        }
        sb.append(planets[planets.length - 1] + "}");
        return sb.toString();
    }
}
