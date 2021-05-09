package com.regadera.regapasswordmanagerfoss.appData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.appData.model.App
import com.regadera.regapasswordmanagerfoss.globals.MyGlobals
import com.regadera.regapasswordmanagerfoss.relations.UserWithApps

@Dao
interface AppDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApp (app: App)

    @Update
    suspend fun updateApp(app: App)

    @Query("SELECT * FROM app_table ORDER BY appName ASC")
    fun readAppData() : LiveData<List<App>>

}