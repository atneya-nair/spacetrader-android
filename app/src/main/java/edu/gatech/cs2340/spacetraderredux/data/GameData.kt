package edu.gatech.cs2340.spacetraderredux.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import edu.gatech.cs2340.spacetraderredux.domain.Game

@Entity(tableName = "games")
data class GameData(@PrimaryKey val id: Int, val game: Game)