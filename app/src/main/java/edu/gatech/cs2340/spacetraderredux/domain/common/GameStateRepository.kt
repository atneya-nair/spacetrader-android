package edu.gatech.cs2340.spacetraderredux.domain.common

import edu.gatech.cs2340.spacetraderredux.domain.Game
import io.reactivex.Completable
import io.reactivex.Single

interface GameStateRepository {
    fun getGameStates(): Single<Map<Int, Game>>
    fun getGameStateById(id: Int): Single<Game>
    fun setNewGameState(game: Game): Single<Int>
    fun setGameState(id:Int, game: Game): Completable
    fun setRecentGameState(game: Game): Completable
}