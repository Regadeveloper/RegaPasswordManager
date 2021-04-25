package com.regadera.regapasswordmanagerfoss.WebData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.WebData.model.Web

@Dao
interface WebDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeb (web: Web)

    @Update
    suspend fun updateWeb(web: Web)

    @Query("SELECT * FROM web_table ORDER BY id ASC")
    fun readWebData() : LiveData<List<Web>>
}