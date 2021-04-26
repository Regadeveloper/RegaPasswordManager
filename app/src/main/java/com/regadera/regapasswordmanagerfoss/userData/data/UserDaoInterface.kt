package com.regadera.regapasswordmanagerfoss.userData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.userData.model.User

@Dao
interface UserDaoInterface {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser (user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY userName ASC")
    fun readUserData() : LiveData<List<User>>
}