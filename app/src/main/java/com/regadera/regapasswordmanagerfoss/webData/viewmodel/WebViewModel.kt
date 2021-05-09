package com.regadera.regapasswordmanagerfoss.webData.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.regadera.regapasswordmanagerfoss.database.UnifiedDatabase
import com.regadera.regapasswordmanagerfoss.globals.MyGlobals
import com.regadera.regapasswordmanagerfoss.relations.UserWithWebs
import com.regadera.regapasswordmanagerfoss.webData.model.Web
import com.regadera.regapasswordmanagerfoss.webData.repository.WebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WebViewModel (application: Application): AndroidViewModel(application) {

    val readData: LiveData<List<Web>>
    private val repository: WebRepository

    init {
        val userDao = UnifiedDatabase.getInstance(application).webDao
        repository = WebRepository(userDao)
        readData = repository.readData
    }

    fun addWeb (web: Web){
        viewModelScope.launch(Dispatchers.IO){
            repository.addWeb(web)
        }
    }

    fun updateWeb(web: Web){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateWeb(web)
        }
    }

}

