package edu.gatech.cs2340.spacetraderredux.di

import android.content.Context
import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
     @Provides
     @Singleton
     fun provideApplication(): App = app

     @Provides
     @Singleton
     fun provideContext(): Context = app.applicationContext

}