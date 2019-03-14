package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.CompletableFunctionUseCase
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import java.lang.IllegalArgumentException

class TradeUseCase(val gameStateRepository: GameStateRepository, val subscribeScheduler: Scheduler, val postExecutionScheduler: Scheduler):
        CompletableFunctionUseCase<Game, Int, TradeAction>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Int?): Single<Game> {
        return gameStateRepository.getGameStateById(params!!)
    }

    override fun transform(t: Game, params: TradeAction?): Game {
        var player = t.playerState
        if (params!!.price > player.credits && !params.sell) throw IllegalArgumentException("Too poor");

        if (player.ship.cargo.size == player.ship.storageUnits.cargoHold.size) throw IllegalArgumentException("Too full");

        if (params.sell) {
            player.ship.cargo.remove(params.tradeable)
            player.credits += params.price
        } else {
            player.ship.cargo.add(params.tradeable)
            player.credits -= params.price
        }
        return Game(player, t.universe)
    }

    override fun buildOnCompletableSuccess(t: Game): Completable {
        return gameStateRepository.setRecentGameState(t)
    }
}
