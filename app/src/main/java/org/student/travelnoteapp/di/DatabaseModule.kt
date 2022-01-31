package org.student.travelnoteapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.student.travelnoteapp.data.room.TravelDatabase
import org.student.travelnoteapp.data.room.dao.TicketDao
import org.student.travelnoteapp.data.room.dao.TravelDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideTravelDao(travelDatabase: TravelDatabase): TravelDao{
        return travelDatabase.travelDao()
    }

    @Provides
    fun provideTicketDao(travelDatabase: TravelDatabase): TicketDao {
        return travelDatabase.ticketDao()
    }

    @Provides
    @Singleton
    fun provideTravelDatabase(@ApplicationContext appContext: Context): TravelDatabase {
        return Room.databaseBuilder(
            appContext,
            TravelDatabase::class.java,
            "TravelDatabase"
        ).build()
    }

}