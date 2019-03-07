package edu.gatech.cs2340.spacetraderredux.domain

import edu.gatech.cs2340.spacetraderredux.domain.entities.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.SkillType
import edu.gatech.cs2340.spacetraderredux.domain.entities.Skills


class Player(val charName: String, val difficulty: Difficulty,
             val skills: Skills, var ship: Ship, var credits: Int) {

    /**
     * Creates a string representation of the player
     * @return A string representation of the player
     */
    override fun toString(): String {
        return "Player{" +
                "displayName='" + this.charName + '\''.toString() +
                ", pilot=" + skills.pilot +
                ", fighter=" + skills.fighter +
                ", trader=" + skills.trader +
                ", engineer=" + skills.engineer +
                ", ship=" + ship +
                ", credits=" + credits +
                '}'.toString()
    }
}
