package edu.gatech.cs2340.spacetraderredux.ui.systempane

import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import io.reactivex.observers.DisposableSingleObserver

class SystemInfoPresenter(val getCurrentStateUseCase: GetCurrentStateUseCase):
        BasePresenter<SystemInfoView>() {
    override fun initialise() {
        getCurrentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(t: PlayerState) {
                getView()?.displayInfo(t.currSystem.name, t.currPlanet.name, t.currPlanet.techLevel,
                        t.currPlanet.politics, t.currPlanet.specialEvent)
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }

    override fun disposeSubscriptions() {
        getCurrentStateUseCase.dispose()
    }

}