package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.CompletableFunctionUseCase
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class TradeUseCase(val gameStateRepository: GameStateRepository, val subscribeScheduler: Scheduler, val postExecutionScheduler: Scheduler):
        CompletableFunctionUseCase<Game, Int, Int>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Int?): Single<Game> {
        return gameStateRepository.getGameStateById(params!!)
    }

    override fun transform(t: Game, params: Int?): Game {
        var player = t.playerState
        if (params != null) player.credits -= params
        return Game(player, t.universe)
    }

    override fun buildOnCompletableSuccess(t: Game): Completable {
        return gameStateRepository.setRecentGameState(t)
    }
}
