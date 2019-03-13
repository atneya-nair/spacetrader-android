package edu.gatech.cs2340.spacetraderredux.di

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.data.ApplicationRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.usecases.SaveNewGame
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    @Named("ioScheduler")
    internal fun provideIoScheduler() = Schedulers.io()

    @Provides
    @Singleton
    @Named("mainThreadScheduler")
    internal fun provideMainThreadScheduler() = AndroidSchedulers.mainThread()


    @Provides
    @Singleton
    internal fun provideSaveNewGameUseCase(
            gameStateRepository: GameStateRepository,
            @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): SaveNewGame =
            SaveNewGame(gameStateRepository, ioScheduler, mainThreadScheduler)
    @Provides
    @Singleton
    internal fun provideTradeUseCase(
            gameStateRepository: GameStateRepository, @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): TradeUseCase =
            TradeUseCase(gameStateRepository, ioScheduler, mainThreadScheduler)

}