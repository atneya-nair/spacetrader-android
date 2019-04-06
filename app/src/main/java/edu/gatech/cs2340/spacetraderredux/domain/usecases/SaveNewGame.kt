package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single

class SaveNewGame(private val gameStateRepository: GameStateRepository,
                  subscribeScheduler: Scheduler, postExecutionScheduler: Scheduler) :
        UseCase<Int, Game>(subscribeScheduler, postExecutionScheduler) {
    override fun buildUseCaseSingle(params: Game?): Single<Int> =
            gameStateRepository.setNewGameState(params!!)

}