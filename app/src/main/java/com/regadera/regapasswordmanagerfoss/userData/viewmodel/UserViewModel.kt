package com.regadera.regapasswordmanagerfoss.userData.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.regadera.regapasswordmanagerfoss.database.UnifiedDatabase
import com.regadera.regapasswordmanagerfoss.userData.repository.UserRepository
import com.regadera.regapasswordmanagerfoss.userData.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Error

class UserViewModel (application: Application): AndroidViewModel(application) {

    private val readData: LiveData<List<User>>
    private val repository: UserRepository
    val currentUser = MutableLiveData<User?>()


    init {
        val userDao = UnifiedDatabase.getInstance(application).userDao
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

    fun getCurrentUser (userName : String, password : String){
        viewModelScope.launch(Dispatchers.IO){
            currentUser.postValue(repository.getCurrentUser(userName, password))
        }
    }
}