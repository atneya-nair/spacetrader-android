package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.common.CompletableFunctionUseCase
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SpecialEvent
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import java.lang.IllegalStateException

class TravelUseCase(private val gameStateRepository: GameStateRepository,
                    subscribeScheduler: Scheduler, postExecutionScheduler: Scheduler):
        CompletableFunctionUseCase<Game, Int, SolarSystem>(subscribeScheduler,
                postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Int?): Single<Game> {
        return gameStateRepository.getGameStateById(params!!)
    }
    override fun transform(t: Game, solarSystem: SolarSystem?): Game {
        val curSystem = t.playerState.currSystem
        val dist = Math.abs(curSystem.location.x - solarSystem!!.location.x) +
                Math.abs(curSystem.location.y - solarSystem.location.y)
        if (dist / 3 > t.playerState.ship.storageUnits.fuelTank.current)
            throw IllegalStateException("Ship does not have fuel for this journey!")
        t.playerState.currSystem = solarSystem
        t.playerState.currPlanet = solarSystem.planets[0] // TODO pick planets
        var specialEvent = t.playerState.currPlanet.specialEvent
        val value = (0..600).random() // TODO make less common again after demo
        if (value < 560) {
            specialEvent =  SpecialEvent.values()[value / 70]
        }
        t.playerState.currPlanet.specialEvent = specialEvent
        t.playerState.ship.storageUnits.fuelTank.current -= dist / 3
        return Game(t.playerState, t.universe)
    }

    override fun buildOnCompletableSuccess(t: Game): Completable {
        return gameStateRepository.setRecentGameState(t)
    }
}
