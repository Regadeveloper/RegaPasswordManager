package com.regadera.regapasswordmanagerfoss.webData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.webData.model.Web

@Dao
interface WebDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeb (web: Web)

    @Update
    suspend fun updateWeb(web: Web)

    @Query("SELECT * FROM web_table ORDER BY id ASC")
    fun readWebData() : LiveData<List<Web>>
}