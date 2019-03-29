package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.common.CompletableFunctionUseCase
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import io.reactivex.Scheduler
import io.reactivex.Single
import java.lang.IllegalStateException

class TravelUseCase(val gameStateRepository: GameStateRepository, val subscribeScheduler: Scheduler, val postExecutionScheduler: Scheduler):
        CompletableFunctionUseCase<Game, Int, SolarSystem>(subscribeScheduler, postExecutionScheduler) {
    override fun buildUseCaseSingle(params: Int?): Single<Game> {
        return gameStateRepository.getGameStateById(params!!)
    }
    override fun transform(t: Game, solarSystem: SolarSystem?): Game {
        var curSystem = t.playerState.currSystem
        var dist = Math.abs(curSystem.location.x - solarSystem!!.location.x) +
                Math.abs(curSystem.location.y - solarSystem!!.location.y)
        if (dist > t.playerState.ship.storageUnits.fuelTank) throw IllegalStateException(
                "Ship does not have fuel for this journey!")
    }
}
