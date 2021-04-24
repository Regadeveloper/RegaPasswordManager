package com.regadera.regapasswordmanagerfoss.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.regadera.regapasswordmanagerfoss.model.User

@Dao
interface UserDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser (user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readData() : LiveData<List<User>>
}