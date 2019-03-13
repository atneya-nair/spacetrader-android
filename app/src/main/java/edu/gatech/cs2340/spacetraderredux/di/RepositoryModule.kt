package edu.gatech.cs2340.spacetraderredux.di

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.data.ApplicationRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    //TODO Change to real DB
    fun provideApplicationRepository(app: App): GameStateRepository = ApplicationRepository(app)
}