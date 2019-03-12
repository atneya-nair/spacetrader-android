package edu.gatech.cs2340.spacetraderredux.domain.entities

import edu.gatech.cs2340.spacetraderredux.domain.Planet


class BuyMarketPlace(planet: Planet, playerState: PlayerState): BaseMarketPlace(planet) {
    init {
        enumValues<Tradeable>().forEach {
            var modifiedPrice = this.marketPrice.get(it)!!
            if (modifiedPrice == 0) {
                modifiedPrice = 0
            } else {
                if (planet.techLevel.ordinal < it.minProduceLevel.ordinal) {
                    modifiedPrice = 0
                } else {
                    modifiedPrice = ((playerState.skills.trader - playerState.skills.MAX_SKILL) / 2) + 100 * modifiedPrice / 100
                    this.marketPrice.put(it, modifiedPrice)
                }
            }
        }
    }

}