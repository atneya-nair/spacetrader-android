package edu.gatech.cs2340.spacetraderredux.Model;

public class Ship {
    ShipType shipType;
    public Ship() {
        shipType = ShipType.GNAT;
    }

    @Override
    public String toString() {
        return shipType.toString();
    }
}
