package edu.gatech.cs2340.spacetraderredux.data

import edu.gatech.cs2340.spacetraderredux.domain.Game

interface GameDataRepository {
    fun addNew(game: Game)
    fun retrieveGame(id: Int): Game
    fun saveGame(id: Int, game: Game)
}