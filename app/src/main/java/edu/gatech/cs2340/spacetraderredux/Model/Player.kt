package edu.gatech.cs2340.spacetraderredux.Model

class Player
/**
 * Constructor to create a player from the given information.
 * @param name the displayName of the new player
 * @param pilot the pilot skill level
 * @param fighter the fighter skill level
 * @param trader the trader skill level
 * @param engineer the engineer skill level
 */
(private val name: String,
 /**
  * Getter for the pilot skill value
  * @return the pilot skill value of the player
  */
 val pilot: Int,
 /**
  * Getter for the fighter  skill value
  * @return the fighter skill value of the player
  */
 val fighter: Int,
 /**
  * Getter for the fighter skill value
  * @return the fighter skill value of the player
  */
 val trader: Int,
 /**
  * Getter for the fighter skill value
  * @return the fighter skill value of the player
  */
 val engineer: Int) {
    private val ship: Ship
    private val credits: Int

    init {
        credits = 1000
        ship = Ship()
    }

    /**
     * Creates a string representation of the player
     * @return A string representation of the player
     */
    override fun toString(): String {
        return "Player{" +
                "displayName='" + name + '\''.toString() +
                ", pilot=" + pilot +
                ", fighter=" + fighter +
                ", trader=" + trader +
                ", engineer=" + engineer +
                ", ship=" + ship +
                ", credits=" + credits +
                '}'.toString()
    }
}
