package edu.gatech.cs2340.spacetraderredux.Model;


public class GameInstance {
    private final Player player;
    private final Difficulty difficulty;
    private final Universe universe;

    public GameInstance(Player player, Difficulty difficulty) {
        this.player = player;
        this.difficulty = difficulty;
        this.universe = new Universe();
    }

    public Player getPlayer() {
        return player;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Universe getUniverse() {
        return universe;
    }

}
