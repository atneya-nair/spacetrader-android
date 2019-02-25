package edu.gatech.cs2340.spacetraderredux.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;

import edu.gatech.cs2340.spacetraderredux.Model.*;

public class ConfigurationViewModel extends ViewModel {
    private static final int MAX_SKILLPOINTS = 16;
    private static final String DEFAULT_PLAYER_NAME = "Player1";
    private static final Difficulty DEFAULT_PLAYER_DIFFICULTY = Difficulty.EASY;

    public Difficulty difficulty = DEFAULT_PLAYER_DIFFICULTY;
    private String name = DEFAULT_PLAYER_NAME;
    public int pilot;
    public int fighter;
    public int trader;
    public int engineer;
    private int remaining = MAX_SKILLPOINTS;

    /**
     * Updates the number of remaining skill point by recalculating how many skill points have been
     * used.
     */
    public void updateRemaining() {
        remaining = MAX_SKILLPOINTS - (pilot + fighter + trader + engineer);
    }

    /**
     * Returns the number of remaining skill points as a string.
     * @return A string stating the number of skill points remaining
     */
    public String getRemaining() {
        return Integer.toString(remaining);
    }

    /**
     * Increments the difficulty, wrapping around to EASY if the difficulty is IMPOSSIBLE.
     */
    public void incDifficulty() {
        difficulty = Difficulty.values()[(difficulty.ordinal() + 1) % Difficulty.values().length];
    }

    /**
     * Decrements the difficulty, wrapping around to IMPOSSIBLE if the difficulty is EASY.
     */
    public void decDifficulty() {
        difficulty = Difficulty.values()[(difficulty.ordinal() + Difficulty.values().length - 1) % Difficulty.values().length];
    }

    /**
     * Decremnts the number of points allocated to a skill if it is greater than 0, otherwise makes
     * no change.
     * @param skillType the SkillType indicating which skill to decrement.
     */
    public void decPoints(SkillType skillType) {
        switch (skillType) {
            case PILOT:
                if (pilot > 0) pilot--;
                break;
            case FIGHTER:
                if (fighter > 0) fighter--;
                break;
            case TRADER:
                if (trader > 0) trader--;
                break;
            case ENGINEER:
                if (engineer > 0) engineer--;
                break;
        }
        updateRemaining();
    }

    /**
     * Increments the number of points allocated to a skill if there are skill points remaining,
     * otherwise makes no change.
     * @param skillType the SkillType indicating which skill to increment.
     */
    public void incPoints(SkillType skillType) {
       if (remaining > 0) {
           switch (skillType) {
               case PILOT:
                   pilot++;
                   break;
               case FIGHTER:
                   fighter++;
                   break;
               case TRADER:
                   trader++;
                   break;
               case ENGINEER:
                   engineer++;
                   break;
           }
       }
       updateRemaining();
    }

    /**
     * Sets the name of the player
     * @param name the new name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the current configuration to create a new player is valid.
     * @return if the current configuration would create a valid player
     */
    public boolean validPlayer() {
        updateRemaining();
        return name.length() > 0 && (remaining == 0);
    }

    /**
     * Creates the player and returns a string representation
     * @return a string representation of the created player
     */
    public String createPlayer() {
        Player player = new Player(name, pilot, fighter, trader, engineer);
        return player.toString();
    }

    /**
     * Creates a bundle containing all the game data
     * @return a bundle containing all the game data
     */
    public Bundle createGameDataBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("playerName", name);
        bundle.putIntArray("playerStats", new int[]{pilot, fighter, trader, engineer});
        bundle.putInt("difficulty", difficulty.ordinal());
        return bundle;
    }
}
