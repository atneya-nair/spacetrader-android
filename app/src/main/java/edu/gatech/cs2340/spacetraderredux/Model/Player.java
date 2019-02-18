package edu.gatech.cs2340.spacetraderredux.Model;

public class Player {
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private Ship ship;
    private int credits;

    public Player (int pilot, int fighter, int trader, int engineer) {
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        credits = 1000;
        ship = new Ship();
    }

    public int getPilot() {
        return pilot;
    }

    public int getFighter() {
        return fighter;
    }

    public int getTrader() {
        return trader;
    }

    public int getEngineer() {
        return engineer;
    }


}
