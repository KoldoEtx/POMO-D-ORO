package com.example.pomodoro.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pomodoro.data.model.Sesion
import com.example.pomodoro.data.model.SesionDao

@Database(entities = [Sesion::class], version = 1)
abstract class PomodoroDatabase : RoomDatabase() {
    abstract fun SesionDao(): SesionDao

    companion object {
        @Volatile
        private var INSTANCE: PomodoroDatabase? = null

        fun getDatabase(context: Context): PomodoroDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PomodoroDatabase::class.java,
                    "pomodorobbdd"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
