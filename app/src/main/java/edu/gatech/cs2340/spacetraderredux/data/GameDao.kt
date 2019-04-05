package edu.gatech.cs2340.spacetraderredux.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import edu.gatech.cs2340.spacetraderredux.domain.Game
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface GameDao {
    @Query("Select * FROM games")
    fun  getAllgames(): Single<List<GameData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gameData: GameData)

    @Query("SELECT * FROM games WHERE id LIKE :id LIMIT 1")//TODO change multiple ids
    fun getGame(id: Int): Single<GameData>
}