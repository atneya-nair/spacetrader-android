package edu.gatech.cs2340.spacetraderredux.ui.shipyard

import android.util.Log
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ShipYardPresenter @Inject constructor(private val currentStateUseCase: GetCurrentStateUseCase) : BasePresenter<ShipYardView>() {
    override fun disposeSubscriptions() {
        currentStateUseCase.dispose()
    }

    override fun initialise() {
        getView()?.initialiseView()
    }

    fun onInitialise() {
        getView()?.updateTab()
    }

    fun onRepair() {
        var playerState: PlayerState? = null
        currentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(platerStateResult: PlayerState) {
                val hullStrengthDiff = platerStateResult.ship.hull.maxHullStrength - platerStateResult.ship.hull.currstrength
                platerStateResult.ship.hull.currstrength = platerStateResult.ship.hull.maxHullStrength
                platerStateResult.credits -= hullStrengthDiff * platerStateResult.ship.hull.repairCost
                Log.d("hull strength", " " + platerStateResult.ship.hull.currstrength)
                Log.d("hull strength", " " + platerStateResult.credits)

            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }
}