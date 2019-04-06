package edu.gatech.cs2340.spacetraderredux.data

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import io.reactivex.Completable
import io.reactivex.Single

class RoomRepository(private val gameDao: GameDao, var counter: Int = -1): GameStateRepository {

    override fun getGameStates(): Single<Map<Int, Game>> {
        return gameDao.getAllgames().map {
            val out = HashMap<Int, Game>()
            it.forEach { gameData ->
                out[gameData.id] = gameData.game
            }
            return@map out
        }
    }

    override fun getGameStateById(id: Int): Single<Game> {
        return gameDao.getGame(id).map { it.game }
    }

    override fun setNewGameState(game: Game): Single<Int> {
        return Completable.fromAction {
            gameDao.insert(GameData(0, game))
        }.toSingleDefault(0)//TODO use counter for multiple
    }

    override fun setGameState(id: Int, game: Game): Completable {
        return Completable.fromAction { gameDao.insert(GameData(0, game)) }
    }

    override fun setRecentGameState(game: Game): Completable {
        return Completable.fromAction { gameDao.insert(GameData(0, game)) }
    }
}