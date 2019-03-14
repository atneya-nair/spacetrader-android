package edu.gatech.cs2340.spacetraderredux.ui.tradespec

import android.arch.lifecycle.ViewModel
import android.util.Log
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState

class TradeSpecificationViewModel : ViewModel() {
    var labelValue = 0
    var transactionCredits = 0
    lateinit var trade: Trade
    var isBuy: Boolean = false
    var playerState: PlayerState = TradeActivity.game!!.playerState

    fun incPoints() {
        if (isBuy && (((labelValue + 1) * trade.price) > playerState.credits || playerState.ship.storageUnits.cargoHold.capacityLeft < labelValue + 1)) {
            return
        } else if (!isBuy) {
            if (playerState.ship.storageUnits.cargoHold.getItems().get(trade.tradeable) ?: 0 <  labelValue + 1) {
                return
            }
        }

        labelValue++
        transactionCredits += trade.price
    }

    fun decPoints() {
        if (labelValue != 0) {
            labelValue--
            transactionCredits -= trade.price
        }
    }

    fun transact() {
        if (isBuy) {
            playerState.credits -= labelValue * trade.price
            playerState.ship.storageUnits.cargoHold.addItems(trade.tradeable, labelValue)
        } else {
            playerState.credits += labelValue * trade.price
            playerState.ship.storageUnits.cargoHold.addItems(trade.tradeable, -labelValue)
        }
    }
}
