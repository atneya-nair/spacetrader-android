package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoPresenter

@Module
class SystemInfoModule {
    @PerActivity
    @Provides
    fun provideSystemInfoPresenter(currentStateUseCase: GetCurrentStateUseCase) = SystemInfoPresenter(currentStateUseCase)
}