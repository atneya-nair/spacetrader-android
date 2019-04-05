package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import android.arch.lifecycle.ViewModel
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import io.reactivex.CompletableObserver
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class TradeSpecificationViewModel : ViewModel() {
    @Inject
    lateinit var tradeUseCase: TradeUseCase
    var labelValue = 0
    var transactionCredits = 0
    lateinit var trade: Trade
    var isBuy: Boolean = false
    var playerState: PlayerState = TradeActivity.playerState!!

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
        tradeUseCase.execute(object: DisposableCompletableObserver() {
            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }, 0, TradeAction(trade, labelValue, !isBuy))

    }
}
