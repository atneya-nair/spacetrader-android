package edu.gatech.cs2340.spacetraderredux.di

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.data.GameDao
import edu.gatech.cs2340.spacetraderredux.data.GameDatabase
import edu.gatech.cs2340.spacetraderredux.data.RoomRepository
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import javax.inject.Singleton

@Module
class RepositoryModule {
    //@Provides
    //@Singleton
    //TODO Change to real DB
    //fun provideApplicationRepository(app: App): GameStateRepository = ApplicationRepository(app)


    @Provides
    @Singleton
    fun provideGameDatabase(context: Context): GameDatabase = Room.databaseBuilder(context,
            GameDatabase::class.java, "games.db")
            .allowMainThreadQueries() // TODO remove this, only for testing
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideGameDao(gameDatabase: GameDatabase): GameDao = gameDatabase.gameDao()

    @Provides
    @Singleton
    fun provideRoomRepository(gameDao: GameDao): GameStateRepository = RoomRepository(gameDao)
}