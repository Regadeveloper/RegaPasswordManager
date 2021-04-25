package com.regadera.regapasswordmanagerfoss.userData.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.regadera.regapasswordmanagerfoss.userData.data.UserDatabase
import com.regadera.regapasswordmanagerfoss.userData.repository.UserRepository
import com.regadera.regapasswordmanagerfoss.userData.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (application: Application): AndroidViewModel(application) {

    val readData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readData = repository.readData
    }

    fun addUser (user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
}