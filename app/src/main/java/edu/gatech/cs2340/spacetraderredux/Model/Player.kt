package edu.gatech.cs2340.spacetraderredux.Model

import edu.gatech.cs2340.spacetraderredux.Model.configuration.PlayerConfiguration
import edu.gatech.cs2340.spacetraderredux.Model.ship.Ship
import edu.gatech.cs2340.spacetraderredux.Model.ship.types.Gnat
import edu.gatech.cs2340.spacetraderredux.Model.ship.types.ShipFactory

class Player {
    val name: String
    val pilot: Int
    val fighter: Int
    val trader: Int
    val engineer: Int
    val ship: Ship
    val credits: Int

    init {
        credits = 1000
        ship = ShipFactory.createShip(Gnat::class)

        var playerConfiguration = PlayerConfiguration.getInstance()
        name = playerConfiguration.playerName
        pilot = playerConfiguration.getSkillPoints(SkillType.PILOT)
        fighter = playerConfiguration.getSkillPoints(SkillType.FIGHTER)
        trader = playerConfiguration.getSkillPoints(SkillType.TRADER)
        engineer = playerConfiguration.getSkillPoints(SkillType.ENGINEER)
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
