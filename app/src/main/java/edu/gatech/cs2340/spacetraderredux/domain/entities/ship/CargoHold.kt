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
        val currentNum = items[tradeable] ?: 0
        if (currentNum + num != 0) {
            items[tradeable] = currentNum + num
        }
    }

    fun removeItems(tradeable: Tradeable, num: Int) {
        val curItems = items[tradeable] ?: 0
        if (curItems < num)
            throw IllegalStateException("Cargo hold does not have enough items to sell!")
        if (curItems - num == 0) {
            items.remove(tradeable)
        } else {
            items[tradeable] = curItems - num
        }
        capacityLeft += num
    }
    fun getItems(): Map<Tradeable, Int> {
        return items
    }
}