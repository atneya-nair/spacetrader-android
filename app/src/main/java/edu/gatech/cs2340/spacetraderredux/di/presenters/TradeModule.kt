package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.App

@Module
internal class TradeModule {
    /*@PerActivity
    @Provides
    fun provideTradePresenter(tradeUseCase: TradeUseCase, app: App): TradePresenter {
        return TradePresenter(tradeUseCase, app)
    }*/
}
