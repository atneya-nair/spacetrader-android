package edu.gatech.cs2340.spacetraderredux.domain.entities

import edu.gatech.cs2340.spacetraderredux.domain.Planet

//TODO tradeable skill stuff (and crew member)
//TODO all quantity items
open class BaseMarketPlace(private val planet: Planet) {
    val marketPrice = HashMap<Tradeable, Int>()
    init {
        enumValues<Tradeable>().forEach { marketPrice[it] = getPrice(it) }
    }
    private fun getPrice(tradeable: Tradeable): Int {
        var price = 0
        if (((tradeable == Tradeable.NARCOTICS) && (!this.planet.politics.drugLegality)) ||
		    ((tradeable == Tradeable.FIREARMS) && (!this.planet.politics.drugLegality))) return 0
		if (planet.techLevel.ordinal < tradeable.minUseLevel.ordinal) return 0

        price = tradeable.baseLevelPrice + ((this.planet.techLevel.ordinal - tradeable.minUseLevel.ordinal) * tradeable.incPerLevel)

        if (tradeable == this.planet.politics.tradeItemDemand)
            price = (price * 4) / 3;

        price = (price * (100 - (2 * this.planet.politics.traderStrength))) / 100

        // No calculation based on system size

        if (planet.resource == tradeable.cheapResource) price = (price * 3) / 4
        if (planet.resource == tradeable.expensiveResource) price = (price * 4) / 3
        if (planet.specialEvent == tradeable.demandEvent) price *= 3
        price += ((-tradeable.percentVariance..tradeable.percentVariance).random()) * price / 100
        if (price < 0) return 0
        return price;
    }
}