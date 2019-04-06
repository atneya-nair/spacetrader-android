package edu.gatech.cs2340.spacetraderredux.di

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.usecases.*
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
    @Provides
    @Singleton
    internal fun provideTravelUseCase(
            gameStateRepository: GameStateRepository, @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): TravelUseCase =
            TravelUseCase(gameStateRepository, ioScheduler, mainThreadScheduler)
    @Provides
    @Singleton
    internal fun provideGetMapUseCase(
            gameStateRepository: GameStateRepository, @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetMapUseCase =
            GetMapUseCase(gameStateRepository, ioScheduler, mainThreadScheduler)

    @Provides
    @Singleton
    internal fun provideGetCurrentStateUseCase(
            gameStateRepository: GameStateRepository, @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetCurrentStateUseCase =
            GetCurrentStateUseCase(gameStateRepository, ioScheduler, mainThreadScheduler)

    @Provides
    @Singleton
    internal fun provideGetMarketPlaceUseCase(
            gameStateRepository: GameStateRepository, @Named("ioScheduler") ioScheduler: Scheduler,
            @Named("mainThreadScheduler") mainThreadScheduler: Scheduler): GetMarketPlaceUseCase =
            GetMarketPlaceUseCase(gameStateRepository, ioScheduler, mainThreadScheduler)





}