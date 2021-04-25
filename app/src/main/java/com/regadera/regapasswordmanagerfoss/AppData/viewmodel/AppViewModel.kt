package com.regadera.regapasswordmanagerfoss.AppData.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.regadera.regapasswordmanagerfoss.AppData.data.AppDatabase
import com.regadera.regapasswordmanagerfoss.AppData.repository.AppRepository
import com.regadera.regapasswordmanagerfoss.AppData.model.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel (application: Application): AndroidViewModel(application) {

    val readData: LiveData<List<App>>
    private val repository: AppRepository

    init {
        val userDao = AppDatabase.getDatabase(application).appDao()
        repository = AppRepository(userDao)
        readData = repository.readData
    }

    fun addWeb (app: App){
        viewModelScope.launch(Dispatchers.IO){
            repository.addApp(app)
        }
    }

    fun updateApp(app: App){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateApp(app)
        }
    }
}