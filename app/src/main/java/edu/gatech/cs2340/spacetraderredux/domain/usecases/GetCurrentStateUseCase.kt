package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.UseCase
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import io.reactivex.Scheduler
import io.reactivex.Single


class GetCurrentStateUseCase(private val gameStateRepository: GameStateRepository,
                    subscribeScheduler: Scheduler, postExecutionScheduler: Scheduler) :
        UseCase<PlayerState, Int>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Int?): Single<PlayerState> {
        val game = gameStateRepository.getGameStateById(0)
        return game.map {
            return@map it.playerState
        }
    }
}