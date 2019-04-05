package edu.gatech.cs2340.spacetraderredux.domain.entities.ship

import android.util.Log
import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import java.lang.IllegalStateException
import java.util.HashMap

class CargoHold constructor(val size: Int) {
    var capacityLeft: Int = size

    private val items: MutableMap<Tradeable, Int>  = HashMap()

    fun addItems(tradeable: Tradeable, num: Int) {
        capacityLeft -= num
        if (capacityLeft < 0) throw IllegalStateException("Cargo hold is full, cannot add items!")
        var currentNum = items.get(tradeable) ?: 0
        if (currentNum + num != 0) {
            items.put(tradeable, currentNum!! + num)
        }
    }

    fun removeItems(tradeable: Tradeable, num: Int) {
        var curItems = items.get(tradeable) ?: 0
        if (curItems < num) throw IllegalStateException("Cargo hold does not have enough items to sell!")
        Log.i("INFO", curItems.toString() + " " + num.toString());
        if (curItems + num == 0) {
            items.remove(tradeable)
        } else {
            items.put(tradeable, curItems - num)
        }
    }
    fun getItems(): Map<Tradeable, Int> {
        return items
    }
}