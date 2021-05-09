package com.regadera.regapasswordmanagerfoss.appData.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.regadera.regapasswordmanagerfoss.appData.repository.AppRepository
import com.regadera.regapasswordmanagerfoss.appData.model.App
import com.regadera.regapasswordmanagerfoss.database.UnifiedDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel (application: Application): AndroidViewModel(application) {

    val readData: LiveData<List<App>>
    private val repository: AppRepository

    init {
        val userDao = UnifiedDatabase.getInstance(application).appDao
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