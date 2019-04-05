package edu.gatech.cs2340.spacetraderredux.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters

@Database(entities = arrayOf(GameData::class), version = 1, exportSchema = false)
@TypeConverters(GameConverter::class)
abstract class GameDatabase: RoomDatabase() {
    abstract fun gameDao(): GameDao
}