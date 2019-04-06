package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single


class GetMapUseCase(private val gameStateRepository: GameStateRepository,
                            subscribeScheduler: Scheduler, postExecutionScheduler: Scheduler) :
        UseCase<List<SolarSystem>, Int>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Int?): Single<List<SolarSystem>> {
        val game = gameStateRepository.getGameStateById(0)
        return game.map {
            return@map it.universe.solarSystems
        }
    }
}