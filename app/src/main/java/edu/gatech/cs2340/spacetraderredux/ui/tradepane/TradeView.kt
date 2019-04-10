package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import kotlin.reflect.KClass

interface TradeView {
    fun setPlanetName(name: String)
    fun displayTrades(trades: List<Trade>)
    fun displayBuyDialog(trade: Trade)
    fun displaySellDialog(trade: Trade)
    fun displayToast(message: String)
    fun setBuyQuantity(quantity: Int, newTotal: Int)
    fun setSellQuantity(quantity: Int, newTotal: Int)
    fun closeDialog()
    fun <T>changeActivity(newActivity: Class<T>)
}
