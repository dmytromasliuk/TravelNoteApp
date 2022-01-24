package org.student.travelnoteapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.student.travelnoteapp.data.room.dao.TravelDao
import org.student.travelnoteapp.data.room.model.Travel

@Database(
    entities = [Travel::class],
    version = 1
)
abstract class TravelDatabase: RoomDatabase() {

    abstract fun travelDao(): TravelDao

//    companion object{
//
//        @Volatile
//        var INSTANCE: TravelDatabase? = null
//
//        fun getDatabase(context: Context): TravelDatabase{
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    TravelDatabase::class.java,
//                    "travel_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }

}