package com.regadera.regapasswordmanagerfoss.WebData.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.regadera.regapasswordmanagerfoss.WebData.model.Web

@Database(entities = [Web::class], version = 1, exportSchema = false)
abstract class WebDatabase : RoomDatabase() {

    abstract fun webDao() : WebDaoInterface

    companion object{
        @Volatile
        private var INSTANCE: WebDatabase? = null

        fun getDatabase (context: Context): WebDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WebDatabase::class.java,
                    "web_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}