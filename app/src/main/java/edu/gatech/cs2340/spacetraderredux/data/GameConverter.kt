package edu.gatech.cs2340.spacetraderredux.data

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import edu.gatech.cs2340.spacetraderredux.domain.Game
import com.google.gson.GsonBuilder
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship


class GameConverter {
     @TypeConverter
     fun fromGame(game: Game): String {
         return Gson().toJson(game)
     }

     @TypeConverter
     fun toGame(string: String): Game {
         //registerTypeAdapter(Ship::class.java, InterfaceAdapter<Ship>())
         var gson = GsonBuilder().create()
         return gson.fromJson(string, Game::class.java)
     }
}