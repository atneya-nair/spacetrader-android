package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.*
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import java.lang.IllegalArgumentException

class SaveNewGame(private val gameStateRepository: GameStateRepository,
                  subscribeScheduler: Scheduler, postExecutionScheduler: Scheduler) : UseCase<Int, Game>(subscribeScheduler, postExecutionScheduler) {
    companion object {
        private const val GAME_STATE = "game_state"

    }
    override fun buildUseCaseSingle(params: Game?): Single<Int> = gameStateRepository.setNewGameState(params!!)

}