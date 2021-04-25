package com.regadera.regapasswordmanagerfoss.WebData.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.regadera.regapasswordmanagerfoss.WebData.model.Web
import com.regadera.regapasswordmanagerfoss.WebData.data.WebDatabase
import com.regadera.regapasswordmanagerfoss.WebData.repository.WebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WebViewModel (application: Application): AndroidViewModel(application) {

    val readData: LiveData<List<Web>>
    private val repository: WebRepository

    init {
        val userDao = WebDatabase.getDatabase(application).webDao()
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