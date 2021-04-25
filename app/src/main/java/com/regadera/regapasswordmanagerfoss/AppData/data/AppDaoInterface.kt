package com.regadera.regapasswordmanagerfoss.AppData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.AppData.model.App

@Dao
interface AppDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApp (app: App)

    @Update
    suspend fun updateApp(app: App)

    @Query("SELECT * FROM app_table ORDER BY id ASC")
    fun readAppData() : LiveData<List<App>>
}