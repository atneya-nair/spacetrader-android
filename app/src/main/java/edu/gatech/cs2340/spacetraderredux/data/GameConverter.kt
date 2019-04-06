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
<<<<<<< HEAD
         var gson = GsonBuilder().create()
||||||| merged common ancestors
         //registerTypeAdapter(Ship::class.java, InterfaceAdapter<Ship>())
         var gson = GsonBuilder().create()
=======
         //registerTypeAdapter(Ship::class.java, InterfaceAdapter<Ship>())
         val gson = GsonBuilder().create()
>>>>>>> da8bed8ea14e4bef4ea7d56dae3bf9ae9460347e
         return gson.fromJson(string, Game::class.java)
     }
}