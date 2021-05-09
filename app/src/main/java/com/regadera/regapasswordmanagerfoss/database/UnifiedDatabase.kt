package com.regadera.regapasswordmanagerfoss.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.regadera.regapasswordmanagerfoss.appData.data.AppDaoInterface
import com.regadera.regapasswordmanagerfoss.appData.model.App
import com.regadera.regapasswordmanagerfoss.userData.data.UserDaoInterface
import com.regadera.regapasswordmanagerfoss.userData.model.User
import com.regadera.regapasswordmanagerfoss.webData.data.WebDaoInterface
import com.regadera.regapasswordmanagerfoss.webData.model.Web

@Database(
    entities = [
        User::class,
        Web::class,
        App::class
    ],
    version = 1

)

abstract class UnifiedDatabase : RoomDatabase() {

    abstract val userDao: UserDaoInterface
    abstract val webDao: WebDaoInterface
    abstract val appDao: AppDaoInterface

    companion object {
        @Volatile
        private var INSTANCE : UnifiedDatabase? = null

        fun getInstance(context: Context): UnifiedDatabase {
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    UnifiedDatabase::class.java,
                    "unified_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}