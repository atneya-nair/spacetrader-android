package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import android.arch.lifecycle.ViewModel
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import io.reactivex.observers.DisposableCompletableObserver
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
