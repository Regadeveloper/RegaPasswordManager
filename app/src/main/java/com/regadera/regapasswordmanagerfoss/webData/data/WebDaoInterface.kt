package com.regadera.regapasswordmanagerfoss.webData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.relations.UserWithWebs
import com.regadera.regapasswordmanagerfoss.webData.model.Web

@Dao
interface WebDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeb (web: Web)

    @Update
    suspend fun updateWeb(web: Web)

    @Query("SELECT * FROM web_table ORDER BY website ASC")
    fun readWebData() : LiveData<List<Web>>

    @Transaction
    @Query("SELECT * FROM web_table WHERE ownerUser LIKE :userName")
    suspend fun getUserWithWebs(userName: String): List<UserWithWebs>
}