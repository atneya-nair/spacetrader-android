package edu.gatech.cs2340.spacetraderredux.Model;

public class Player {
    private String name;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private Ship ship;
    private int credits;

    /**
     * Constructor to create a player from the given information.
     * @param name the name of the new player
     * @param pilot the pilot skill level
     * @param fighter the fighter skill level
     * @param trader the trader skill level
     * @param engineer the engineer skill level
     */
    public Player (String name, int pilot, int fighter, int trader, int engineer) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        credits = 1000;
        ship = new Ship();
    }

    /**
     * Getter for the pilot skill value
     * @return the pilot skill value of the player
     */
    public int getPilot() {
        return pilot;
    }

    /**
     * Getter for the fighter  skill value
     * @return the fighter skill value of the player
     */
    public int getFighter() {
        return fighter;
    }

    /**
     * Getter for the fighter skill value
     * @return the fighter skill value of the player
     */
    public int getTrader() {
        return trader;
    }

    /**
     * Getter for the fighter skill value
     * @return the fighter skill value of the player
     */
    public int getEngineer() {
        return engineer;
    }

    /**
     * Creates a string representation of the player
     * @return A string representation of the player
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pilot=" + pilot +
                ", fighter=" + fighter +
                ", trader=" + trader +
                ", engineer=" + engineer +
                ", ship=" + ship +
                ", credits=" + credits +
                '}';
    }
}
