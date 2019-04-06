package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.CompletableFunctionUseCase
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.entities.TradeAction
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

class TradeUseCase(val gameStateRepository: GameStateRepository, subscribeScheduler: Scheduler,
                   postExecutionScheduler: Scheduler):
        CompletableFunctionUseCase<Game, Int, TradeAction>(subscribeScheduler,
                postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Int?): Single<Game> {
        return gameStateRepository.getGameStateById(params!!)
    }

    override fun transform(t: Game, tradeAction: TradeAction?): Game {
        val player = t.playerState
        if (!tradeAction!!.sell) {
            //TODO move code from cargo hold to here
            player.credits -= tradeAction.trade.price *
                    tradeAction.quantity
            if (player.credits < 0) throw IllegalStateException("Not enough money to buy item!")
            player.ship.storageUnits.cargoHold.addItems(tradeAction.trade.tradeable,
                    tradeAction.quantity)
        } else {
            player.ship.storageUnits.cargoHold.removeItems(tradeAction.trade.tradeable,
                    tradeAction.quantity)
            player.credits += tradeAction.trade.price *
                    tradeAction.quantity
        }

        return Game(player, t.universe)
    }

    override fun buildOnCompletableSuccess(t: Game): Completable {
        return gameStateRepository.setRecentGameState(t)
    }
}
