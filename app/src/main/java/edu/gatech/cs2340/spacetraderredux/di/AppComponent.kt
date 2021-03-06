package edu.gatech.cs2340.spacetraderredux.di

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.domain.usecases.*
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(app: App)
    fun getSaveNewGameUseCase(): SaveNewGame
    fun tradeUseCase(): TradeUseCase
    fun getMapUseCase(): GetMapUseCase
    fun getCurrentStateUseCase(): GetCurrentStateUseCase
    fun getMarketPlaceUseCase(): GetMarketPlaceUseCase
    fun travelUseCase(): TravelUseCase
}