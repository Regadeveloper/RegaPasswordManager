package com.regadera.regapasswordmanagerfoss.repository


import androidx.lifecycle.LiveData
import com.regadera.regapasswordmanagerfoss.data.UserDaoInterface
import com.regadera.regapasswordmanagerfoss.model.User

class UserRepository (private val userDao : UserDaoInterface) {

    val readData: LiveData<List<User>> = userDao.readData()

    suspend fun addUser (user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser (user: User){
        userDao.updateUser(user)
    }
}