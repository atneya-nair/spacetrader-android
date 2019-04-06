package edu.gatech.cs2340.spacetraderredux.data

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import edu.gatech.cs2340.spacetraderredux.domain.Game


class GameConverter {
     @TypeConverter
     fun fromGame(game: Game): String {
         return Gson().toJson(game)
     }

     @TypeConverter
     fun toGame(string: String): Game {
         val gson = GsonBuilder().create()

         return gson.fromJson(string, Game::class.java)
     }
}