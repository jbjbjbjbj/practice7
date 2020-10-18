package com.example.bus

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ticket::class, Passenger::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPassengerDao(): PassengerDao

    companion object {

        private const val DB_NAME = "bus.db"

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    AppDatabase::class.java, DB_NAME).build()
            }

            return instance
        }
    }

}