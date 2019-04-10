package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradePresenter

@Module
class TradeModule {
    @PerActivity
    @Provides
    fun provideTradePresenter(currentStateUseCase: GetCurrentStateUseCase,
                              tradeUseCase: TradeUseCase)
            = TradePresenter(currentStateUseCase, tradeUseCase)
}