package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import edu.gatech.cs2340.spacetraderredux.domain.entities.BuyMarketPlace
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import edu.gatech.cs2340.spacetraderredux.ui.cargopane.CargoActivity
import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class TradePresenter @Inject constructor(val getCurrentStateUseCase: GetCurrentStateUseCase,
                                         val tradeUseCase: TradeUseCase) :
        BasePresenter<TradeView>() {
    private lateinit var playerState: PlayerState
    private var currentTrade: Trade? = null
    private var currentQuantity: Int = 0

    override fun initialise() {
        getCurrentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(t: PlayerState) {
                playerState = t
                initialiseView()
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }

    fun initialiseView() {
        val view = getView()!!
        view.setPlanetName(playerState.currPlanet.name.name)

        val trades = ArrayList<Trade>()
        val bmp = BuyMarketPlace(playerState.currPlanet, playerState)
        for (element in bmp.marketPrice) {
            if (element.value == 0) {
                continue
            }
            trades.add(Trade(element.key, element.value))
        }
        view.displayTrades(trades)
    }

    fun onSystemInfoClick() {
        getView()?.changeActivity(SystemInfoActivity::class.java)
    }

    fun onCargoClick() {
        getView()?.changeActivity(CargoActivity::class.java)
    }

    fun onTradeableClick() {
        getView()?.displayToast("Already on Trade page!")
    }

    fun onSolarClick() {
        getView()?.changeActivity(MapActivity::class.java)
    }

    fun onIncrementBuyQuantityClick() {
        if ((currentQuantity + 1) * currentTrade!!.price > playerState.credits) {
            return
        }
        currentQuantity++
        getView()?.setBuyQuantity(currentQuantity, currentQuantity * currentTrade!!.price)
    }

    fun onDecrementBuyQuantityClick() {
        if (currentQuantity == 0) {
            return
        }
        currentQuantity--
        getView()?.setBuyQuantity(currentQuantity, currentQuantity * currentTrade!!.price)
    }

    fun onIncrementSellQuantityClick() {
        if (!playerState.ship.storageUnits.cargoHold.getItems()
                        .containsKey(currentTrade!!.tradeable)) {
            return
        }
        if (currentQuantity + 1 > playerState.ship.storageUnits.cargoHold.getItems()
                        .getValue(currentTrade!!.tradeable)) {
            return
        }
        currentQuantity++
        getView()?.setSellQuantity(currentQuantity, currentQuantity * currentTrade!!.price)
    }

    fun onDecrementSellQuantityClick() {
        if (currentQuantity == 0) {
            return
        }
        currentQuantity--
        getView()?.setSellQuantity(currentQuantity, currentQuantity * currentTrade!!.price)
    }

    fun onBuyClick(trade: Trade) {
        currentQuantity = 0
        currentTrade = trade
        getView()?.displayBuyDialog(trade)
    }

    fun onSellClick(trade: Trade) {
        currentQuantity = 0
        currentTrade = trade
        getView()?.displaySellDialog(trade)
    }

    fun onCancelTransaction() {
        getView()?.closeDialog()
    }

    fun onBuyConfirmation() {
        tradeUseCase.execute(object: DisposableCompletableObserver() {
            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }, 0, TradeAction(currentTrade!!, currentQuantity,
                false))
        getView()?.closeDialog()
    }

    fun onSellConfirmation() {
        tradeUseCase.execute(object: DisposableCompletableObserver() {
            override fun onComplete() {

            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }, 0, TradeAction(currentTrade!!, currentQuantity,
                true))
        getView()?.closeDialog()
    }

    override fun disposeSubscriptions() {
        getCurrentStateUseCase.dispose()
    }

}
