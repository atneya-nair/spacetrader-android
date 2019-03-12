package edu.gatech.cs2340.spacetraderredux.di

import android.app.Activity
import dagger.Component
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.usecases.SaveNewGame
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(app: App)
    fun getSaveNewGameUseCase(): SaveNewGame
}