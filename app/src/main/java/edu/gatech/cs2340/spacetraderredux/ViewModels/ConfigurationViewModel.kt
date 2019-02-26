package edu.gatech.cs2340.spacetraderredux.ViewModels

import android.arch.lifecycle.ViewModel
import android.os.Bundle

import edu.gatech.cs2340.spacetraderredux.Model.*
import javax.inject.Inject

class ConfigurationViewModel @Inject constructor(): ViewModel() {

    var difficulty = DEFAULT_PLAYER_DIFFICULTY
    var playername = DEFAULT_PLAYER_NAME
    var pilot = 0
    var fighter = 0
    var trader = 0
    var engineer = 0
    var remaining = MAX_SKILLPOINTS

    /**
     * Updates the number of remaining skill point by recalculating how many skill points have been
     * used.
     */
    fun updateRemaining() {
        remaining = MAX_SKILLPOINTS - (pilot + fighter + trader + engineer)
    }

    /**
     * Returns the number of remaining skill points as a string.
     * @return A string stating the number of skill points remaining
     */
    fun getRemaining(): String {
        return Integer.toString(remaining)
    }

    /**
     * Increments the difficulty, wrapping around to EASY if the difficulty is IMPOSSIBLE.
     */
    fun incDifficulty() {
        difficulty = Difficulty.values()[(difficulty.ordinal + 1) % Difficulty.values().size]
    }

    /**
     * Decrements the difficulty, wrapping around to IMPOSSIBLE if the difficulty is EASY.
     */
    fun decDifficulty() {
        difficulty = Difficulty.values()[(difficulty.ordinal + Difficulty.values().size - 1) % Difficulty.values().size]
    }

    /**
     * Decremnts the number of points allocated to a skill if it is greater than 0, otherwise makes
     * no change.
     * @param skillType the SkillType indicating which skill to decrement.
     */
    fun decPoints(skillType: SkillType) {
        when (skillType) {
            SkillType.PILOT -> if (pilot > 0) pilot--
            SkillType.FIGHTER -> if (fighter > 0) fighter--
            SkillType.TRADER -> if (trader > 0) trader--
            SkillType.ENGINEER -> if (engineer > 0) engineer--
        }
        updateRemaining()
    }

    /**
     * Increments the number of points allocated to a skill if there are skill points remaining,
     * otherwise makes no change.
     * @param skillType the SkillType indicating which skill to increment.
     */
    fun incPoints(skillType: SkillType) {
        if (remaining > 0) {
            when (skillType) {
                SkillType.PILOT -> pilot++
                SkillType.FIGHTER -> fighter++
                SkillType.TRADER -> trader++
                SkillType.ENGINEER -> engineer++
            }
        }
        updateRemaining()
    }

    /**
     * Sets the name of the player
     * @param name the new name of the player
     */
    fun setName(name: String) {
        this.playername = name
    }

    /**
     * Checks if the current configuration to create a new player is valid.
     * @return if the current configuration would create a valid player
     */
    fun validPlayer(): Boolean {
        updateRemaining()
        return playername.length > 0 && remaining == 0
    }

    /**
     * Creates the player and returns a string representation
     * @return a string representation of the created player
     */
    fun createPlayer(): String {
        val player = Player(playername, pilot, fighter, trader, engineer)
        return player.toString()
    }

    /**
     * Creates a bundle containing all the game data
     * @return a bundle containing all the game data
     */
    fun createGameDataBundle(): Bundle {
        val bundle = Bundle()
        bundle.putString("playerName", playername)
        bundle.putIntArray("playerStats", intArrayOf(pilot, fighter, trader, engineer))
        bundle.putInt("difficulty", difficulty.ordinal)
        return bundle
    }

    companion object {
        private val MAX_SKILLPOINTS = 16
        private val DEFAULT_PLAYER_NAME = "Player1"
        private val DEFAULT_PLAYER_DIFFICULTY = Difficulty.EASY
    }
}
