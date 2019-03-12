package edu.gatech.cs2340.spacetraderredux.data


import edu.gatech.cs2340.spacetraderredux.ui.common.App
import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.IllegalStateException

class ApplicationRepository(val app: App): GameStateRepository {
    //TODO This datastore lives on the application for testing purposes, stubbed methods
    override fun getGameStates(): Single<Map<Int, Game>> {
        val map = HashMap<Int, Game>()
        if (app.game == null) return Single.error(IllegalAccessError()) else map[1] = app.game!!
        return Single.just(map)
    }
    override fun getGameStateById(id: Int): Single<Game> {
        if (app.game == null) return Single.error(IllegalAccessError()) else return Single.just(app.game)
    }
    override fun setNewGameState(game: Game): Single<Int> {
        app.game = game
        return Single.just(1)
    }

    override fun setGameState(id:Int, game: Game): Completable {
        app.game = game
        return Completable.complete()
    }
}