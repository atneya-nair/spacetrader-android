package edu.gatech.cs2340.spacetraderredux.domain.entities.ship

import android.util.Log
import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import edu.gatech.cs2340.spacetraderredux.ui.tradespec.Trade
import java.util.HashMap

class CargoHold constructor(val size: Int) {
    var capacityLeft: Int = size
        private set
    private val items: MutableMap<Tradeable, Int>  = HashMap()

    fun addItems(tradeable: Tradeable, num: Int) {
        capacityLeft -= num
        var currentNum = items.get(tradeable)
        if (currentNum == null) {
            currentNum = 0
        }
        items.put(tradeable, currentNum!! + num)
        if (items[tradeable] == 0) {
            items.remove(tradeable)
        }
    }

    fun getItems(): Map<Tradeable, Int> {
        return items
    }
}