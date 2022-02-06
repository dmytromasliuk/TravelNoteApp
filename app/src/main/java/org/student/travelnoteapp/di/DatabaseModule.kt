package org.student.travelnoteapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.student.travelnoteapp.data.room.TravelDatabase
import org.student.travelnoteapp.data.room.dao.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideProfileDao(travelDatabase: TravelDatabase): ProfileDao {
        return travelDatabase.profileDao()
    }

    @Provides
    fun provideTravelDao(travelDatabase: TravelDatabase): TravelDao{
        return travelDatabase.travelDao()
    }

    @Provides
    fun provideTicketDao(travelDatabase: TravelDatabase): TicketDao {
        return travelDatabase.ticketDao()
    }

    @Provides
    fun providePlaceDao(travelDatabase: TravelDatabase): PlaceDao {
        return travelDatabase.placeDao()
    }

    @Provides
    fun provideBookingDao(travelDatabase: TravelDatabase): BookingDao {
        return travelDatabase.bookingDao()
    }

    @Provides
    fun provideAddressDao(travelDatabase: TravelDatabase): AddressDao {
        return travelDatabase.addressDao()
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