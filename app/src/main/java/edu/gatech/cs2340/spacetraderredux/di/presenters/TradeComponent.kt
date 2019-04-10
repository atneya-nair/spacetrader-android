package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.di.AppComponent
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [TradeModule::class])
interface TradeComponent {
    fun inject(tradeActivity: TradeActivity)
}