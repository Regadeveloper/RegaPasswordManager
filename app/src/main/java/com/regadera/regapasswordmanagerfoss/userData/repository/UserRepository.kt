package com.regadera.regapasswordmanagerfoss.userData.repository


import androidx.lifecycle.LiveData
import com.regadera.regapasswordmanagerfoss.userData.data.UserDaoInterface
import com.regadera.regapasswordmanagerfoss.userData.model.User

class UserRepository (private val userDao : UserDaoInterface) {

    val readData: LiveData<List<User>> = userDao.readUserData()
    

    suspend fun addUser (user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser (user: User){
        userDao.updateUser(user)
    }

    suspend fun getCurrentUser (userName : String, password: String): User?{
         return userDao.getUser(userName, password )
    }




}