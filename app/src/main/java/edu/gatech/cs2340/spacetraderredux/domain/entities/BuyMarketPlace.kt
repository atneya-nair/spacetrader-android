package edu.gatech.cs2340.spacetraderredux.domain.entities

import edu.gatech.cs2340.spacetraderredux.domain.Planet


class BuyMarketPlace(planet: Planet, playerState: PlayerState): BaseMarketPlace(planet) {
    init {
        enumValues<Tradeable>().forEach {
            var modifiedPrice = this.marketPrice[it]!!
            if (modifiedPrice != 0) {
                modifiedPrice = if (planet.techLevel.ordinal < it.minProduceLevel.ordinal) {
                    0
                } else {
                    ((playerState.skills.trader - Skills.MAX_SKILL) / 2) + 100 * modifiedPrice / 100
                }
                this.marketPrice[it] = modifiedPrice
            }
        }
    }

}