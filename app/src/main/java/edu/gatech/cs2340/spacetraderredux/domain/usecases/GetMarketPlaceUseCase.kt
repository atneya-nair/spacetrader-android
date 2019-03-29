package edu.gatech.cs2340.spacetraderredux.domain.usecases

import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.UseCase
import edu.gatech.cs2340.spacetraderredux.domain.entities.BuyMarketPlace
import io.reactivex.Scheduler
import io.reactivex.Single

class GetMarketPlaceUseCase(private val gameStateRepository: GameStateRepository,
                            subscribeScheduler: Scheduler, postExecutionScheduler: Scheduler) : UseCase<BuyMarketPlace, Int>(subscribeScheduler, postExecutionScheduler) {
    override fun buildUseCaseSingle(params: Int?): Single<BuyMarketPlace> {
        var game = gameStateRepository.getGameStateById(0)
        return game.map {
            return@map BuyMarketPlace(it.playerState.currPlanet, it.playerState)
        }
    }
}