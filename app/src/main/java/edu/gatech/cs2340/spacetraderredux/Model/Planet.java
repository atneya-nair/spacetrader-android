package edu.gatech.cs2340.spacetraderredux.Model;

import java.util.Random;

public class Planet {

    private final PlanetName name;
    private final Resource resource;
    private final TechLevel techLevel;

    public Planet(Random seed) {
        this.name = PlanetName.values()[seed.nextInt(PlanetName.values().length)];
        this.resource = Resource.values()[seed.nextInt(Resource.values().length)];
        this.techLevel = TechLevel.values()[seed.nextInt(TechLevel.values().length)];
    }

    public PlanetName getName() {
        return name;
    }

    public Resource getResource() {
        return resource;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    @Override
    public String toString() {
        return "Planet " + name.name() + " with resource: " + resource.name() + " and tech level: " + techLevel.name();
    }
}
