package edu.gatech.cs2340.spacetraderredux.di

import android.app.Application
import edu.gatech.cs2340.spacetraderredux.domain.Game

class SpaceTraderGlobal: Application() {
    var game: Game? = null
}