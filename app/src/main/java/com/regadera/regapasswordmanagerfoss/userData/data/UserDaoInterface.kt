package com.regadera.regapasswordmanagerfoss.userData.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.regadera.regapasswordmanagerfoss.appData.model.App
import com.regadera.regapasswordmanagerfoss.globals.MyGlobals
import com.regadera.regapasswordmanagerfoss.relations.UserWithApps
import com.regadera.regapasswordmanagerfoss.relations.UserWithWebs
import com.regadera.regapasswordmanagerfoss.userData.model.User
import com.regadera.regapasswordmanagerfoss.webData.model.Web

@Dao
interface UserDaoInterface {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser (user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY userName ASC")
    fun readUserData() : LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE userName LIKE :userName AND mainPassword LIKE :password")
    suspend fun getUser(userName: String, password : String) : User?


    @Transaction
    @Query("SELECT * FROM user_table WHERE userName LIKE :userName ")
    fun getUserWithWebs(userName: String = MyGlobals.currentUserName): LiveData<List<UserWithWebs?>>

    @Transaction
    @Query("SELECT * FROM user_table WHERE userName LIKE :userName ")
    fun getUserWithApps(userName: String = MyGlobals.currentUserName): LiveData<List<UserWithApps?>>

}

