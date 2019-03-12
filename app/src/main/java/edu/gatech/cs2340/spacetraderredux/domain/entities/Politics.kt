package edu.gatech.cs2340.spacetraderredux.domain.entities

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable

enum class Politics(val displayName:String, val traffickingReaction: Int, val policeStrength: Int,
                        val pirateStrength: Int, val traderStrength: Int,
                        val minTechLevel: TechLevel, val maxTechLevel: TechLevel,
                        val bribeLevel: Int, val drugLegality: Boolean,
                        val firearmLegality: Boolean, val tradeItemDemand: Tradeable) {
    //TODO add all politics
    DEMOCRACY(
            "Democracy",
            4,
            3,
            2,
            5,
            TechLevel.RENAISSANCE,
            TechLevel.HI_TECH,
            2,
            false,
            true,
            Tradeable.GAMES
    )
}