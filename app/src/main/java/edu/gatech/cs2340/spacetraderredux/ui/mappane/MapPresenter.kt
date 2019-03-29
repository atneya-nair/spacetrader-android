package edu.gatech.cs2340.spacetraderredux.ui.mappane

import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetMapUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TravelUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MapPresenter @Inject constructor(
        var mapUseCase: GetMapUseCase, var travelUseCase: TravelUseCase, var currentStateUseCase: GetCurrentStateUseCase): BasePresenter<MapView>() {
    override fun disposeSubscriptions() {
        mapUseCase.dispose()
        travelUseCase.dispose()
        currentStateUseCase.dispose()
    }

    override fun initialise() {
        getView()?.initialiseView()
    }

    fun onInitialise() {
        var solarSystems: List<SolarSystem>? = null
        var playerState: PlayerState? = null
        mapUseCase.execute(object: DisposableSingleObserver<List<SolarSystem>>() {
            override fun onSuccess(solarSystemsResult: List<SolarSystem>) {
                if (playerState != null) {
                    getView()?.displaySolarSystems(solarSystemsResult, playerState!!)
                } else {
                    solarSystems = solarSystemsResult
                }
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })

        currentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(playerStateResult: PlayerState) {
                if (solarSystems != null) {
                    getView()?.displaySolarSystems(solarSystems!!, playerStateResult)
                } else {
                    playerState = playerStateResult
                }
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }

    fun onTravel(solarSystem: SolarSystem) {
        travelUseCase.execute(object: DisposableCompletableObserver() {
            override fun onComplete() {
                getView()?.onSuccessfulTravel()
            }

            override fun onError(e: Throwable) {
                getView()?.onInvalidTravel(e.message!!)
            }

        }, 0, solarSystem)
    }

    fun onSelectSolarSystem(solarSystem: SolarSystem) {
        currentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(playerStateResult: PlayerState) {
                var x = playerStateResult.currSystem.location.x
                var y = playerStateResult.currSystem.location.y
                var distance = Math.abs(x - solarSystem.location.x) + Math.abs(y - solarSystem.location.y)
                var fuelCost = distance / 3
                var fuelRemaining = playerStateResult.ship.storageUnits.fuelTank.current
                getView()?.showConfirmationDialogue(solarSystem, String.format("Travel to system at (%d, %d)\nFuel Remeaining: %d\nFuel Cost: %d\nDistance %d", x, y, fuelRemaining, fuelCost, distance))
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }
}