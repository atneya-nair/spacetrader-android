package edu.gatech.cs2340.spacetraderredux.ui.common

import android.app.Application
import edu.gatech.cs2340.spacetraderredux.di.AppComponent
import edu.gatech.cs2340.spacetraderredux.di.AppModule
import edu.gatech.cs2340.spacetraderredux.di.DaggerAppComponent
import edu.gatech.cs2340.spacetraderredux.domain.Game

class App: Application() {
    var game: Game? = null
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent.inject(this)
    }
}